package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun StatusScreen(
  viewState: PokemonDetail.ViewState,
) {
  Column {
    AttributeRow(viewState = viewState)
    StatusColumn(viewState = viewState)
  }
}