package com.serj113.feature.pokemonlist.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.core.model.DataItem

@Composable
internal fun PokemonListScreen(pokemonList: List<DataItem>) {
  LazyVerticalGrid(
    columns = GridCells.Adaptive(minSize = 128.dp)
  ) {
    items(pokemonList) { pokemon ->
      PokemonItem(pokemon = pokemon)
    }
  }
}

@Preview
@Composable
internal fun PreviewPokemonListScreen() {
  PokemonListScreen(
    listOf(
      DataItem("Pikachu", "Link"),
      DataItem("Bulbasaur", "Link"),
      DataItem("Charmender", "Link"),
      DataItem("Squirturtle", "Link"),
    )
  )
}