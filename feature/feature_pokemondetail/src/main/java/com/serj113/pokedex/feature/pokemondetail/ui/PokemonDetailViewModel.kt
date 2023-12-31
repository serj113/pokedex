package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import arrow.core.Either
import com.serj113.pokedex.common.navigation.Parameter
import com.serj113.pokedex.common.presentation.PokemonColor
import com.serj113.pokedex.core.domain.usecase.GetEvolutionChainUseCase
import com.serj113.pokedex.core.domain.usecase.GetAbilitiesUseCase
import com.serj113.pokedex.core.domain.usecase.GetColorWithSpeciesIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetMovesWithIdUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.utils.getSpeciesId
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
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
  private val pokemonColorUseCase: GetColorWithSpeciesIdUseCase,
  private val pokemonAbilitiesUseCase: GetAbilitiesUseCase,
  private val pokemonMovesUseCase: GetMovesWithIdUseCase,
  private val evolutionChainUseCase: GetEvolutionChainUseCase,
) : ViewModel(), IPokemonDetailViewModel {

  private val _viewState = MutableStateFlow(PokemonDetail.ViewState())
  val viewStateFlow: StateFlow<PokemonDetail.ViewState> = _viewState

  override val uiAction = Channel<PokemonDetail.Action>(Channel.BUFFERED)

  private val _uiEvent = Channel<PokemonDetail.Event>(Channel.BUFFERED)
  val uiEvent = _uiEvent.receiveAsFlow()

  init {
    uiAction.receiveAsFlow()
      .onEach { action ->
        onUiAction(action)
      }
      .launchIn(viewModelScope)
  }

  private fun onUiAction(action: PokemonDetail.Action) {
    when (action) {
      PokemonDetail.Action.InnitPage -> {
        val pokemonId: Int = checkNotNull(savedStateHandle[Parameter.POKEMON_ID])
        getPokemonDetail(pokemonId)
        getPokemonAbilities(pokemonId)
        getPokemonMoves(pokemonId)
        getEvolutionChain(pokemonId)
      }

      PokemonDetail.Action.OnBackPressed -> viewModelScope.launch {
        _uiEvent.send(PokemonDetail.Event.GoBack)
      }

      PokemonDetail.Action.OnFavoritePressed -> {

      }
    }
  }

  private fun getPokemonDetail(pokemonId: Int) {
    viewModelScope.launch {
      _viewState.update { viewState ->
        viewState.copy(
          pokemonId = pokemonId,
        )
      }
      when (val result = useCase(pokemonId)) {

        is arrow.core.Either.Left -> {
          _viewState.update { viewState ->
            viewState.copy(
              pokemonDetail = result.value
            )
          }
          getPokemonColor(result.value.species.getSpeciesId())
        }

        is arrow.core.Either.Right -> {}
      }
    }
  }

  private fun getPokemonAbilities(pokemonId: Int) {
    viewModelScope.launch {
      when (val abilities = pokemonAbilitiesUseCase(pokemonId)) {
        is Either.Left -> {
          _viewState.update { viewState ->
            viewState.copy(
              abilities = abilities.value,
            )
          }
          abilities.value
        }

        is Either.Right -> {}
      }
    }
  }

  private fun getPokemonMoves(pokemonId: Int) {
    viewModelScope.launch {
      when (val moves = pokemonMovesUseCase(pokemonId)) {
        is Either.Left -> {
          _viewState.update { viewState ->
            viewState.copy(
              movesViewState = PokemonDetail.MovesViewState.Loaded(
                moves = moves.value,
              )
            )
          }
        }

        is Either.Right -> {}
      }
    }
  }

  private suspend fun getPokemonColor(speciesId: Int) {
    when (val result = pokemonColorUseCase(speciesId)) {
      is ApiResult.Success -> {
        _viewState.update { viewState ->
          viewState.copy(
            pokemonColor = PokemonColor.getComposeColor(result.value),
          )
        }
      }

      is ApiResult.Error -> {

      }
    }
  }

  private fun getEvolutionChain(pokemonId: Int) {
    viewModelScope.launch {
      when (val evolutionChain = evolutionChainUseCase(pokemonId)) {
        is Either.Left -> {
          _viewState.update { viewState ->
            viewState.copy(
              evolutionChain = evolutionChain.value,
            )
          }
        }

        is Either.Right -> {}
      }
    }
  }
}