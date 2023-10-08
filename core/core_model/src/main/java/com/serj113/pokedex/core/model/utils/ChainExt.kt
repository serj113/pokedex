package com.serj113.pokedex.core.model.utils

import com.serj113.pokedex.core.model.Chain

fun Chain.depth(): Int {
  var max = 0
  evolvesTo.forEach {
    val depth = it.depth()
    if (max < depth) {
      max = depth
    }
  }
  return 1 + max
}