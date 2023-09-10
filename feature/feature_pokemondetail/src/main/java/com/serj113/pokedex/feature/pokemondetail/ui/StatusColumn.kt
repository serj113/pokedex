package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun StatusColumn(
  viewState: PokemonDetail.ViewState,
) {
  Column(
    modifier = Modifier
      .fillMaxWidth()
      .padding(start = 8.dp, end = 8.dp),
  ) {
    viewState.pokemonDetail.stats.map { stat ->
      StatusItem(stat = stat)
    }
  }
}