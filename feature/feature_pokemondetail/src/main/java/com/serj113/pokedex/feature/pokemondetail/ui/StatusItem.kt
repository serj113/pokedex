package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
  Row(
    modifier = Modifier
      .padding(4.dp),
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(
      text = PokemonStatus.getStatusAbbreviation(stat),
      fontWeight = PokemonStatus.getStatusFontWeight(stat),
    )
    Spacer(modifier = Modifier.width(8.dp))
    LinearProgressIndicator(
      progress = PokemonStatus.getStatusProgress(stat)
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