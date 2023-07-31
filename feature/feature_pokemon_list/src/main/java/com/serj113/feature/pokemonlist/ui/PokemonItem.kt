package com.serj113.feature.pokemonlist.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.core.model.DataItem

@Composable
fun PokemonItem(pokemon: DataItem) {
  Card(
    shape = RoundedCornerShape(8.dp),
  ) {
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.padding(24.dp)
    ) {
      Text(
        text = pokemon.name,
        style = MaterialTheme.typography.bodyLarge
      )
    }
  }
}

@Preview
@Composable
fun PreviewPokemonItem() {
  PokemonItem(DataItem("Pikachu", "Link"))
}