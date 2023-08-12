package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serj113.pokedex.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList
import dagger.hilt.android.lifecycle.HiltViewModel
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
) : ViewModel(), IPokemonListViewModel {

  private val _viewState = MutableStateFlow(PokemonList.ViewState())
  val viewStateFlow: StateFlow<PokemonList.ViewState> = _viewState

  private val _event = Channel<PokemonList.Event>(Channel.BUFFERED)
  val eventFlow = _event.receiveAsFlow()

  override val uiAction = Channel<PokemonList.Action>(Channel.BUFFERED)

  init {
    uiAction.receiveAsFlow()
      .onEach { action ->
        onUiAction(action)
      }
      .launchIn(viewModelScope)
  }

  private fun onUiAction(action: PokemonList.Action) {
    when (action) {
      is PokemonList.Action.OnClickItem -> {
        _event.trySend(PokemonList.Event.GoToDetail(action.pokemonId))
      }
      PokemonList.Action.InitPage -> {
        fetchPokemonList()
      }
    }
  }

  private fun fetchPokemonList() = viewModelScope.launch {
    when (val result = useCase()) {
      is ApiResult.Success -> {
        _viewState.update { viewState ->
          viewState.copy(
            pokemonList = result.value.results
          )
        }
      }

      is ApiResult.Error -> {

      }
    }
  }
}