package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.serj113.pokedex.core.model.Chain
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.depth

@Composable
fun EvolutionColumn(chain: Chain) {
  if (chain.evolvesTo.isNotEmpty()) {
    var curChain = chain
    val weight: Float = 1f / curChain.depth()
    var repeat = true
    Row(
      modifier = Modifier
        .fillMaxWidth(),
      verticalAlignment = Alignment.CenterVertically,
    ) {
      while (repeat) {
        EvolutionItem(
          pokemon = curChain.species,
          modifier = Modifier
            .weight(weight)
        )
        when {
          curChain.evolvesTo.size > 1 -> {
            Column(
              modifier = Modifier
                .weight(1f - weight)
            ) {
              curChain.evolvesTo.forEach {
                EvolutionColumn(
                  chain = it,
                )
              }
            }
            repeat = false
          }

          curChain.evolvesTo.size == 1 -> {
            curChain = curChain.evolvesTo.first()
          }

          else -> repeat = false
        }
      }
    }
  } else {
    EvolutionItem(
      pokemon = chain.species,
    )
  }
}

@Preview
@Composable
fun PreviewEvolutionColumn() {
  EvolutionColumn(
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
      ),
    ),
  )
}

@Preview
@Composable
fun PreviewEvolutionMultiValuesColumn() {
  EvolutionColumn(
    chain = Chain(
      evolvesTo = listOf(
        Chain(
          evolvesTo = listOf(),
          species = DataItem(
            name = "Ivysaur",
            url = "",
          )
        ),
        Chain(
          evolvesTo = listOf(),
          species = DataItem(
            name = "Venusaur",
            url = "",
          )
        ),
      ),
      species = DataItem(
        name = "Bulbasaur",
        url = "",
      ),
    ),
  )
}