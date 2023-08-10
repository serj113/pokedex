package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.serj113.pokedex.common.presentation.SpriteImage
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
internal fun PokemonDetailHeader(viewState: PokemonDetail.ViewState) {
  Card(
    shape = RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp),
    modifier = Modifier
      .fillMaxWidth()
      .padding(4.dp),
  ) {
    Column {
      Spacer(
        modifier = Modifier
          .height(24.dp)
      )
      AsyncImage(
        model = SpriteImage.getUrl(viewState.pokemonId),
        contentDescription = null,
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
      )
    }
  }
}

@Preview
@Composable
internal fun PreviewPokemonDetailHeader() {
  PokemonDetailHeader(viewState = PokemonDetail.ViewState())
}