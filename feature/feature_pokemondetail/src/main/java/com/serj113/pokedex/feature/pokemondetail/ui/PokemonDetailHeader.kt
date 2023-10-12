package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.serj113.pokedex.common.presentation.SpriteImage
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
internal fun PokemonDetailHeader(
  viewState: PokemonDetail.ViewState,
) {
  AsyncImage(
    model = SpriteImage.getUrl(viewState.pokemonId),
    contentDescription = null,
    contentScale = ContentScale.FillHeight,
    modifier = Modifier
      .height(250.dp)
      .fillMaxWidth(),
  )
}

@Preview
@Composable
internal fun PreviewPokemonDetailHeader() {
  PokemonDetailHeader(viewState = PokemonDetail.ViewState())
}