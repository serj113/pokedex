package com.serj113.pokedex.core.model.utils

import com.serj113.pokedex.core.model.DataItem

fun DataItem.getPokemonId(): Int {
  return url.split("/").getOrNull(6)?.toInt() ?: 0
}

fun DataItem.getSpeciesId(): Int {
  return url.split("/").getOrNull(6)?.toInt() ?: 0
}