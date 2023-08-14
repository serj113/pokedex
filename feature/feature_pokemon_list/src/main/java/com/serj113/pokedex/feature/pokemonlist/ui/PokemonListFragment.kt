package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.serj113.pokedex.common.navigation.PathGenerator
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList

@Composable
fun PokemonListFragment(navController: NavHostController) {
  val viewModel: PokemonListViewModel = hiltViewModel()
  val viewState by viewModel.viewStateFlow.collectAsState()
  LaunchedEffect(key1 = Unit) {
    viewModel.eventFlow.collect { event ->
      when(event) {
        is PokemonList.Event.GoToDetail -> {
          navController.navigate(PathGenerator.getPokemonDetailPath(event.pokemonId))
        }
      }
    }
  }
  viewModel.uiAction.trySend(PokemonList.Action.FetchNextPage)
  PokemonListScreen(viewState = viewState, viewModel = viewModel)
}