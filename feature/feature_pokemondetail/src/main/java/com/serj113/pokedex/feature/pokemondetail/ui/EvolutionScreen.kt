package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.runtime.Composable
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun EvolutionScreen(
  viewState: PokemonDetail.ViewState,
) {
  if (viewState.evolutionChain.chain.evolvesTo.isNotEmpty()) {
    EvolutionColumn(chain = viewState.evolutionChain.chain)
  }
}