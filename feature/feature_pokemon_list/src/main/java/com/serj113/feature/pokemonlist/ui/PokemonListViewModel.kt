package com.serj113.feature.pokemonlist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.serj113.core.domain.usecase.GetPokemonListUseCase
import com.serj113.feature.pokemonlist.data.PokemonList
import com.serj113.pokedex.core.model.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
  private val useCase: GetPokemonListUseCase,
) : ViewModel() {

  private val _viewState = MutableStateFlow(PokemonList.ViewState())
  val viewStateFlow: StateFlow<PokemonList.ViewState> = _viewState

  init {
    viewModelScope.launch {
      when(val result = useCase()) {
        is ApiResult.Success -> {
          _viewState.update {viewState ->
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
}