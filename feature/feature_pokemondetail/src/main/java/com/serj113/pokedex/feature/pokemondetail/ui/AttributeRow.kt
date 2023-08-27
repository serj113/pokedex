package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun AttributeRow(
  viewState: PokemonDetail.ViewState,
) {
  Row(
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Column(
      verticalArrangement = Arrangement.SpaceEvenly,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Text(
        text = "",
      )
      Text(
        text = "",
      )
    }
    Column(
      verticalArrangement = Arrangement.SpaceEvenly,
      horizontalAlignment = Alignment.CenterHorizontally,
    ) {
      Text(
        text = "",
      )
      Text(
        text = "",
      )
    }
  }
}