package com.serj113.pokedex.core.model.utils

import com.serj113.pokedex.core.model.UrlItem

fun UrlItem.getEvolutionChainId(): Int {
  return url.split("/").getOrNull(6)?.toInt() ?: 0
}