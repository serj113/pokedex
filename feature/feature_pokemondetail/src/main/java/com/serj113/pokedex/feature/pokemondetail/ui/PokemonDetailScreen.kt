package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PokemonDetailScreen(viewState: PokemonDetail.ViewState) {
  MaterialTheme {
    Scaffold { _ ->
      LazyColumn {
        item {
          PokemonDetailHeader(viewState = viewState)
        }
      }
    }
  }
}

@Preview
@Composable
internal fun PreviewPokemonDetailScreen() {
  PokemonDetailScreen(viewState = PokemonDetail.ViewState())
}