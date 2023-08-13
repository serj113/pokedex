package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun PokemonDetailFragment() {
  val viewModel: PokemonDetailViewModel = hiltViewModel()
  val viewState by viewModel.viewStateFlow.collectAsState()
  viewModel.uiAction.trySend(PokemonDetail.Action.InnitPage)
  PokemonDetailScreen(viewState = viewState)
}