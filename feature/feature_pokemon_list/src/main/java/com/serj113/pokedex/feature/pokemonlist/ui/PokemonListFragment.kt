package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.serj113.pokedex.common.navigation.PathGenerator
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListFragment(navController: NavHostController) {
  val viewModel: PokemonListViewModel = hiltViewModel()
  val viewState by viewModel.viewStateFlow.collectAsState()
  LaunchedEffect(key1 = Unit) {
    viewModel.uiEvent.collect { event ->
      when(event) {
        is PokemonList.Event.GoToDetail -> {
          navController.navigate(PathGenerator.getPokemonDetailPath(event.pokemonId))
        }
      }
    }
  }
  MaterialTheme {
    Scaffold { _ ->
      PokemonListScreen(viewState = viewState, viewModel = viewModel)
    }
  }
}