package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
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
import androidx.constraintlayout.compose.ConstraintLayout
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.common.presentation.PokemonType
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.PokemonMoveResponse

@Composable
fun MoveItem(move: PokemonMoveResponse) {
  ConstraintLayout(
    modifier = Modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(8.dp))
      .border(
        border = BorderStroke(1.dp, ComposeColor.black),
        shape = RoundedCornerShape(8.dp),
      )
      .padding(4.dp),
  ) {
    val (name, pp, type) = createRefs()
    Text(
      text = move.name,
      fontWeight = FontWeight.SemiBold,
      modifier = Modifier
        .constrainAs(name) {
          start.linkTo(parent.start)
          top.linkTo(parent.top)
        },
    )
    Text(
      text = move.pp.toString(),
      fontWeight = FontWeight.SemiBold,
      modifier = Modifier
        .constrainAs(pp) {
          top.linkTo(parent.top)
          end.linkTo(parent.end, margin = 4.dp)
        },
    )
    MoveTypeLabel(
      type = move.type,
      modifier = Modifier
        .constrainAs(type) {
          top.linkTo(name.bottom, margin = 4.dp)
          start.linkTo(parent.start, margin = 4.dp)
          bottom.linkTo(parent.bottom, margin = 4.dp)
        },
    )
  }
}

@Composable
fun MoveTypeLabel(
  type: DataItem,
  modifier: Modifier = Modifier,
) {
  Box(
    modifier = modifier
      .clip(RoundedCornerShape(12.dp))
      .background(PokemonType.getTypeColor(type.name))
      .padding(start = 8.dp, end = 8.dp),
  ) {
    Text(
      text = type.name,
      fontWeight = FontWeight.Bold,
    )
  }
}

@Preview
@Composable
fun MoveItemPreview() {
  MoveItem(
    move = PokemonMoveResponse(
      name = "Swift Slash",
      pp = 15,
      type = DataItem(
        name = "normal",
        url = "",
      ),
    ),
  )
}