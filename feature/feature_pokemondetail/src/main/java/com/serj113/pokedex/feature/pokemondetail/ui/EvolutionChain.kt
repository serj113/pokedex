package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.serj113.pokedex.core.model.Chain
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.EvolutionChainResponse
import com.serj113.pokedex.core.model.utils.depth
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@Composable
fun EvolutionChain(
  viewState: PokemonDetail.ViewState,
) {
  if (viewState.evolutionChain.chain.evolvesTo.isNotEmpty()) {
    EvolutionColumn(chain = viewState.evolutionChain.chain)
  }
}

@Preview
@Composable
fun PreviewEvolutionChain() {
  EvolutionChain(
    viewState = PokemonDetail.ViewState(
      evolutionChain = EvolutionChainResponse(
        chain = Chain(
          evolvesTo = listOf(
            Chain(
              evolvesTo = listOf(
                Chain(
                  evolvesTo = listOf(),
                  species = DataItem(
                    name = "Venusaur",
                    url = "",
                  )
                ),
              ),
              species = DataItem(
                name = "Ivysaur",
                url = "",
              )
            ),
          ),
          species = DataItem(
            name = "Bulbasaur",
            url = "",
          )
        )
      )
    )
  )
}