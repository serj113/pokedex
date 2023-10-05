package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.PokemonSlot

@Composable
fun AbilityItem(ability: PokemonAbilityResponse) {
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
  ) {
    Text(
      text = ability.name,
      fontWeight = FontWeight.SemiBold,
    )
    if (ability.pokemon.first().isHidden) {
      AbilityHiddenLabel()
    }
  }
}

@Composable
fun AbilityHiddenLabel() {
  Box(
    modifier = Modifier
      .clip(RoundedCornerShape(12.dp))
      .background(ComposeColor.red_300)
      .padding(start = 8.dp, end = 8.dp),
  ) {
    Text(
      text = "Hidden",
      fontWeight = FontWeight.Bold,
    )
  }
}

@Preview
@Composable
fun AbilityItemPreview() {
  AbilityItem(
    ability = PokemonAbilityResponse(
      id = 1,
      name = "overgrow",
      pokemon = listOf(
        PokemonSlot(
          slot = 1,
          isHidden = true,
          pokemon = DataItem(),
        ),
      ),
    )
  )
}

@Preview
@Composable
fun HiddenAbilityItemPreview() {
  AbilityItem(
    ability = PokemonAbilityResponse(
      id = 1,
      name = "overgrow",
      pokemon = listOf(
        PokemonSlot(
          slot = 1,
          isHidden = false,
          pokemon = DataItem(),
        ),
      ),
    )
  )
}