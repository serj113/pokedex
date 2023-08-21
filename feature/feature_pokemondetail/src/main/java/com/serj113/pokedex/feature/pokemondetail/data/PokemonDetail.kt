package com.serj113.pokedex.feature.pokemondetail.data

import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.PokemonDetailResponse

object PokemonDetail {
  data class ViewState(
    val pokemonId: Int = 0,
    val pokemonDataItem: DataItem = DataItem(),
    val pokemonColor: Int? = null,
    val pokemonDetail: PokemonDetailResponse = PokemonDetailResponse(),
  )

  sealed class Action {
    object InnitPage : Action()
  }
}