package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serj113.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
  private val useCase: GetPokemonDetailUseCase,
) : ViewModel() {

  private val _viewState = MutableStateFlow(PokemonDetail.ViewState())
  val viewStateFlow: StateFlow<PokemonDetail.ViewState> = _viewState

  private fun getPokemonDetail() = viewModelScope.launch {
    when (val result = useCase(_viewState.value.pokemonId)) {
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