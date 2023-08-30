package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.common.presentation.PokemonType
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.Type
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun TypeColumn(
  viewState: PokemonDetail.ViewState,
) {
  Row(
    modifier = Modifier
      .wrapContentHeight()
      .padding(start = 2.dp, end = 2.dp),
    verticalAlignment = Alignment.Bottom,
  ) {
    val total = viewState.pokemonDetail.types.size - 1
    viewState.pokemonDetail.types.mapIndexed { index, type ->
      Column(
        modifier = Modifier
          .padding(start = 2.dp, end = 2.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Icon(
          painter = painterResource(id = PokemonType.getTypeDrawable(type.type.name)),
          contentDescription = null
        )
        Text(
          text = type.type.name.capitalize(),
        )
      }
      if (index < total) {
        Text(
          text = "/",
        )
      }
    }
  }
}

@Preview
@Composable
fun PreviewTypeColumn() {
  TypeColumn(
    viewState = PokemonDetail.ViewState(
      pokemonDetail = PokemonDetailResponse(
        types = listOf(
          Type(
            slot = 1,
            type = DataItem("fighting", "")
          ),
          Type(
            slot = 2,
            type = DataItem("ghost", "")
          ),
        )
      )
    )
  )
}