package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.serj113.pokedex.common.navigation.PathGenerator
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun PokemonDetailFragment(
  onBackPress: () -> Unit,
) {
  val viewModel: PokemonDetailViewModel = hiltViewModel()
  val viewState by viewModel.viewStateFlow.collectAsState()
  viewModel.uiAction.trySend(PokemonDetail.Action.InnitPage)
  LaunchedEffect(key1 = Unit) {
    viewModel.uiEvent.collect { event ->
      when(event) {
        is PokemonDetail.Event.GoBack -> {
          onBackPress.invoke()
        }
      }
    }
  }
  PokemonDetailScreen(
    viewState = viewState,
    viewModel = viewModel,
  )
}