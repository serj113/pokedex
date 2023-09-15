package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Size
import com.serj113.pokedex.common.presentation.SpriteImage
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
internal fun PokemonDetailHeader(
  viewState: PokemonDetail.ViewState,
) {
  Column(
    modifier = Modifier
      .fillMaxWidth(),
  ) {
    Spacer(
      modifier = Modifier
        .height(24.dp)
    )
    val model = ImageRequest.Builder(LocalContext.current)
      .data(SpriteImage.getUrl(viewState.pokemonId))
      .size(Size.ORIGINAL)
      .crossfade(true)
      .build()
    AsyncImage(
      model = model,
      contentDescription = null,
      contentScale = ContentScale.FillWidth,
      modifier = Modifier
        .fillMaxWidth(),
    )
  }
}

@Preview
@Composable
internal fun PreviewPokemonDetailHeader() {
  PokemonDetailHeader(viewState = PokemonDetail.ViewState())
}