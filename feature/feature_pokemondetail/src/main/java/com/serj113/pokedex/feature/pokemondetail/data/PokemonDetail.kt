package com.serj113.pokedex.feature.pokemondetail.data

import com.serj113.pokedex.core.model.DataItem

object PokemonDetail {
  data class ViewState(
    val pokemonId: Int = 0,
    val pokemonDataItem: DataItem = DataItem(),
  )
}