package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serj113.pokedex.common.presentation.PokemonColor
import com.serj113.pokedex.core.domain.usecase.GetColorWithIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.getPokemonId
import com.serj113.pokedex.common.presentation.R as RPresentation
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
  private val useCase: GetPokemonListUseCase,
  private val pokemonColorUseCase: GetColorWithIdUseCase,
) : ViewModel(), IPokemonListViewModel {

  private val _viewState = MutableStateFlow(PokemonList.ViewState())
  val viewStateFlow: StateFlow<PokemonList.ViewState> = _viewState

  private val _event = Channel<PokemonList.Event>(Channel.BUFFERED)
  val eventFlow = _event.receiveAsFlow()

  override val uiAction = Channel<PokemonList.Action>(Channel.BUFFERED)

  private var fetchJob: Job? = null

  init {
    uiAction.receiveAsFlow().onEach { action ->
        onUiAction(action)
      }.launchIn(viewModelScope)
  }

  private fun onUiAction(action: PokemonList.Action) {
    when (action) {
      is PokemonList.Action.OnClickItem -> {
        _event.trySend(PokemonList.Event.GoToDetail(action.pokemonId))
      }

      PokemonList.Action.FetchNextPage -> {
        fetchPokemonList()
      }
    }
  }

  private fun fetchPokemonList() {
    if (fetchJob?.isCompleted == false) return
    fetchJob = viewModelScope.launch {
      when (val result = useCase(_viewState.value.page)) {
        is ApiResult.Success -> {
          _viewState.update { viewState ->
            viewState.copy(
              pokemonList = viewState.pokemonList.plus(result.value.results),
              page = viewState.page + 1
            )
          }
          bulkFetchColor(result.value.results)
        }

        is ApiResult.Error -> {

        }
      }
    }
  }

  private fun bulkFetchColor(pokemonList: List<DataItem>) {
    pokemonList.forEach { pokemon ->
      viewModelScope.launch {
        val pokemonId = pokemon.getPokemonId()
        when (val result = pokemonColorUseCase(pokemonId)) {
          is ApiResult.Success -> {
            _viewState.update { viewState ->
              viewState.copy(pokemonColor = viewState.pokemonColor.apply {
                put(pokemonId, PokemonColor.getComposeColor(result.value))
              })
            }
          }

          is ApiResult.Error -> {

          }
        }
      }
    }
  }
}