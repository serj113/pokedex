package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
internal fun PokemonDetailScreen(viewState: PokemonDetail.ViewState) {
  LazyColumn {
    item {
      PokemonDetailHeader(viewState = viewState)
    }
  }
}

@Preview
@Composable
internal fun PreviewPokemonDetailScreen() {
  PokemonDetailScreen(viewState = PokemonDetail.ViewState())
}