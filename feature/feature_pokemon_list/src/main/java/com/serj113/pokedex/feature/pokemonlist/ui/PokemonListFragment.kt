package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PokemonListFragment() {
  val viewModel: PokemonListViewModel = hiltViewModel()
  val viewState by viewModel.viewStateFlow.collectAsState()
  PokemonListScreen(viewState = viewState)
}