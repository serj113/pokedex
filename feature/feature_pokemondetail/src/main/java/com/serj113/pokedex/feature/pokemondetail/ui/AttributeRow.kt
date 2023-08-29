package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun AttributeRow(
  viewState: PokemonDetail.ViewState,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .wrapContentHeight(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    AttributeItem(
      value = viewState.pokemonDetail.weight.toString(),
      attribute = "Weight"
    )
    AttributeItem(
      value = viewState.pokemonDetail.height.toString(),
      attribute = "Height"
    )
  }
}

@Composable
fun AttributeItem(value: String, attribute: String) {
  Column(
    verticalArrangement = Arrangement.SpaceEvenly,
    horizontalAlignment = Alignment.CenterHorizontally,
  ) {
    Text(
      text = value,
    )
    Text(
      text = attribute,
    )
  }
}

@Preview
@Composable
fun PreviewAttributeRow() {
  AttributeRow(
    viewState = PokemonDetail.ViewState(
      pokemonDetail = PokemonDetailResponse(
        weight = 10,
        height = 10,
      )
    )
  )
}