package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun StatusColumn(
  viewState: PokemonDetail.ViewState,
) {
  Column {
    viewState.pokemonDetail.stats.map { stat ->
      StatusItem(stat = stat)
    }
  }
}