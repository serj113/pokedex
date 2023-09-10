package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.common.presentation.PokemonStatus
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.Stat

@Composable
fun StatusItem(stat: Stat) {
  val color = PokemonStatus.getStatusColor(stat)
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text = PokemonStatus.getStatusAbbreviation(stat),
      fontWeight = PokemonStatus.getStatusFontWeight(stat),
      color = color,
    )
    LinearProgressIndicator(
      progress = PokemonStatus.getStatusProgress(stat),
      color = color,
    )
  }
}

@Preview
@Composable
fun PreviewStatusItem() {
  StatusItem(
    stat = Stat(
      baseStat = 60,
      effort = 0,
      stat = DataItem(
        name = "hp",
        url = "",
      )
    ),
  )
}