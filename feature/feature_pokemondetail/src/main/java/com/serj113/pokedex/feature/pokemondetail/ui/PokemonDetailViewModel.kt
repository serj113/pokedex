package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.common.navigation.Parameter
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail
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
class PokemonDetailViewModel @Inject constructor(
  private val savedStateHandle: SavedStateHandle,
  private val useCase: GetPokemonDetailUseCase,
) : ViewModel(), IPokemonDetailViewModel {

  private val _viewState = MutableStateFlow(PokemonDetail.ViewState())
  val viewStateFlow: StateFlow<PokemonDetail.ViewState> = _viewState

  override val uiAction = Channel<PokemonDetail.Action>(Channel.BUFFERED)

  init {
    uiAction.receiveAsFlow()
      .onEach { action ->
        onUiAction(action)
      }
      .launchIn(viewModelScope)
  }

  private fun onUiAction(action: PokemonDetail.Action) {
    when (action) {
      PokemonDetail.Action.InnitPage -> getPokemonDetail()
    }
  }

  private fun getPokemonDetail() {
    val pokemonId: Int = checkNotNull(savedStateHandle[Parameter.POKEMON_ID])
    viewModelScope.launch {
      _viewState.update { viewState ->
        viewState.copy(
          pokemonId = pokemonId,
        )
      }
      when (val result = useCase(pokemonId)) {
        is ApiResult.Success -> {
          _viewState.update { viewState ->
            viewState.copy(
              pokemonDetail = result.value
            )
          }
        }

        is ApiResult.Error -> {

        }
      }
    }
  }
}