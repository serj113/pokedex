package com.serj113.pokedex.core.model

data class PokemonListResponse(
  val count: Int = 0,
  val next: String? = null,
  val previous: String? = null,
  val results: List<DataItem> = emptyList(),
)