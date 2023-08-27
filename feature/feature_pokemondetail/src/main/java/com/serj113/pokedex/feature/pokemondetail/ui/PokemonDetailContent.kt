package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun PokemonDetailContent(
  viewState: PokemonDetail.ViewState,
) {
  Card(
    colors = CardDefaults.cardColors(
      containerColor = ComposeColor.white,
    )
  ) {
    LazyColumn() {
      item {
        AttributeRow(viewState)
      }
    }
  }
}