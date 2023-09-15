package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.core.model.PokemonMoveResponse

@Composable
fun MoveItem(move: PokemonMoveResponse) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .border(
        border = BorderStroke(1.dp, ComposeColor.black),
        shape = RoundedCornerShape(8.dp),
      )
      .padding(4.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    Text(text = move.name)
    Text(text = move.pp.toString())
  }
}

@Preview
@Composable
fun MoveItemPreview() {
  MoveItem(
    move = PokemonMoveResponse(
      name = "Swift Slash",
      pp = 15,
    ),
  )
}