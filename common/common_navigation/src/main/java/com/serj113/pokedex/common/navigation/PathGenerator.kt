package com.serj113.pokedex.common.navigation

object PathGenerator {

  fun getPokemonDetailPath(pokemonId: Int): String {
    return "${Path.DETAIL_BASIC}/$pokemonId"
  }
}