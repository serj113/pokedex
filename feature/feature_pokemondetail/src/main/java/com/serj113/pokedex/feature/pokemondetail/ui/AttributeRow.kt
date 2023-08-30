package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.Type
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun AttributeRow(
  viewState: PokemonDetail.ViewState,
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .height(IntrinsicSize.Min),
    horizontalArrangement = Arrangement.SpaceEvenly,
    verticalAlignment = Alignment.CenterVertically,
  ) {
    AttributeItem(
      value = viewState.pokemonDetail.weight.toString(),
      attribute = "Weight"
    )
    Divider(
      color = ComposeColor.gray,
      modifier = Modifier
        .fillMaxHeight()
        .width(1.dp)
    )
    TypeColumn(viewState = viewState)
    Divider(
      color = ComposeColor.gray,
      modifier = Modifier
        .fillMaxHeight()
        .width(1.dp)
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
        types = listOf(
          Type(
            slot = 1,
            type = DataItem("fighting", "")
          ),
          Type(
            slot = 2,
            type = DataItem("ghost", "")
          ),
        ),
      )
    )
  )
}