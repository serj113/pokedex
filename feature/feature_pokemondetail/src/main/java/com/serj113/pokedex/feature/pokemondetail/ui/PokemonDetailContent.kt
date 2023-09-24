package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonMoveResponse
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun PokemonDetailContent(
  viewState: PokemonDetail.ViewState,
) {
  Card(
    modifier = Modifier
      .padding(start = 16.dp, end = 16.dp),
    colors = CardDefaults.cardColors(
      containerColor = ComposeColor.white,
    )
  ) {
    Column {
      AttributeRow(viewState = viewState)
      AbilityColumn(viewState = viewState)
      StatusColumn(viewState = viewState)
      MoveColumn(viewState = viewState)
    }
  }
}

@Preview
@Composable
fun PreviewPokemonDetailContent() {
  PokemonDetailContent(
    viewState = PokemonDetail.ViewState(
      pokemonDetail = PokemonDetailResponse(
        weight = 10,
        height = 10,
      ),
      pokemonMoves = listOf(
        PokemonMoveResponse(
          name = "Swift Slash",
          pp = 15,
        ),
        PokemonMoveResponse(
          name = "Thunder Clap",
          pp = 20,
        ),
      ),
    )
  )
}