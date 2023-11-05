package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.common.presentation.ui.CollapsibleSection
import com.serj113.pokedex.core.model.PokemonMoveResponse

@Composable
fun CollapsibleMoveItem(move: PokemonMoveResponse) {
  CollapsibleSection(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .border(
        border = BorderStroke(1.dp, ComposeColor.black),
        shape = RoundedCornerShape(8.dp),
      )
      .padding(8.dp),
    titleContent = {
      MoveItem(move = move)
    }
  ) {
    Text(
      text = move.effectEntries.first { it.language.name == "en" }.effect,
      fontWeight = FontWeight.SemiBold,
    )
  }
}