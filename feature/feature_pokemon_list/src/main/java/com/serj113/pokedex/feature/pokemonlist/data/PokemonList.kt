package com.serj113.pokedex.feature.pokemonlist.data

import com.serj113.pokedex.core.model.DataItem

object PokemonList {

  data class ViewState(
    val count: Int = 0,
    val pokemonList: List<DataItem> = emptyList(),
    val hasNext: Boolean = false,
  )
}