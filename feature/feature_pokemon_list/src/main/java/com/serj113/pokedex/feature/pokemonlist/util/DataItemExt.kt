package com.serj113.pokedex.feature.pokemonlist.util

import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.getPokemonId

fun DataItem.getSpriteImage(): String {
  return Urls.getSpriteImage(getPokemonId())
}