package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.getSpriteImage

@Composable
fun EvolutionItem(pokemon: DataItem, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    AsyncImage(
      model = pokemon.getSpriteImage(),
      contentDescription = null,
    )
    Text(
      text = pokemon.name,
      style = MaterialTheme.typography.bodyLarge
    )
  }
}