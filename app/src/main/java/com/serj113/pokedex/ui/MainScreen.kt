package com.serj113.pokedex.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.serj113.pokedex.common.navigation.Route
import com.serj113.pokedex.feature.pokemondetail.ui.PokemonDetailFragment
import com.serj113.pokedex.feature.pokemonlist.ui.PokemonListFragment

@Composable
fun MainScreen() {
  Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
    val navController = rememberNavController()
    NavHost(
      navController = navController,
      startDestination = Route.List.path,
    ) {
      composable(route = Route.List.path) {
        PokemonListFragment(navController)
      }
      composable(
        route = Route.Detail.path,
        arguments = listOf(
          navArgument("pokemonId") { type = NavType.IntType },
        ),
      ) {
        PokemonDetailFragment(
          onBackPress = {
            navController.popBackStack()
          }
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewMainScreen() {
  MainScreen()
}