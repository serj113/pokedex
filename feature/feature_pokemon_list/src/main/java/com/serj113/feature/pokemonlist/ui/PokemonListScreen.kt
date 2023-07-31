package com.serj113.feature.pokemonlist.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.feature.pokemonlist.data.PokemonList
import com.serj113.pokedex.core.model.DataItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PokemonListScreen(viewState: PokemonList.ViewState) {
  MaterialTheme {
    Scaffold { _ ->
      LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp)
      ) {
        items(viewState.pokemonList) { pokemon ->
          PokemonItem(pokemon = pokemon)
        }
      }
    }
  }
}

@Preview
@Composable
internal fun PreviewPokemonListScreen() {
  PokemonListScreen(
    PokemonList.ViewState(
      pokemonList = listOf(
        DataItem("Pikachu", "Link"),
        DataItem("Bulbasaur", "Link"),
        DataItem("Charmender", "Link"),
        DataItem("Squirturtle", "Link"),
      )
    )
  )
}