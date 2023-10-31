package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
      .padding(start = 16.dp, end = 16.dp)
      .fillMaxSize(),
    colors = CardDefaults.cardColors(
      containerColor = ComposeColor.white,
    )
  ) {
    Column {
      var tabIndex by remember { mutableStateOf(0) }
      val tabs = listOf("Status", "Evolution", "Abilities", "Moves")
      TabRow(
        selectedTabIndex = tabIndex
      ) {
        tabs.forEachIndexed { index, tab ->
          Tab(
            selected = index == tabIndex,
            onClick = {
              tabIndex = index
            },
            text = {
              Text(tab)
            },
          )
        }
      }
      Spacer(
        modifier = Modifier
          .height(4.dp)
      )
      when (tabIndex) {
        0 -> StatusScreen(viewState = viewState)
        1 -> EvolutionScreen(viewState = viewState)
        2 -> AbilitiesScreen(viewState = viewState)
        else -> MovesScreen(viewState = viewState)
      }
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
      movesViewState = PokemonDetail.MovesViewState.Loaded(
        moves = listOf(
          PokemonMoveResponse(
            name = "Swift Slash",
            pp = 15,
          ),
          PokemonMoveResponse(
            name = "Thunder Clap",
            pp = 20,
          ),
        ),
      ),
    )
  )
}