package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun AbilityColumn(viewState: PokemonDetail.ViewState) {
  Column(
    modifier = Modifier
      .wrapContentHeight()
      .fillMaxWidth()
      .padding(start = 8.dp, end = 8.dp),
  ) {
    viewState.abilities.mapIndexed { index, ability ->
      AbilityItem(ability = ability)
      if (index != viewState.abilities.lastIndex) {
        Spacer(modifier = Modifier.height(4.dp))
      }
    }
  }
}