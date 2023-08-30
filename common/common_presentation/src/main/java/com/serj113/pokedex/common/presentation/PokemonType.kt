package com.serj113.pokedex.common.presentation

object PokemonType {
  fun getTypeDrawable(type: String): Int {
    return when (type) {
      "normal" -> R.drawable.type_normal
      "fighting" -> R.drawable.type_fighting
      "flying" -> R.drawable.type_flying
      "poison" -> R.drawable.type_poison
      "ground" -> R.drawable.type_ground
      "rock" -> R.drawable.type_rock
      "bug" -> R.drawable.type_bug
      "ghost" -> R.drawable.type_ghost
      "steel" -> R.drawable.type_steel
      "fire" -> R.drawable.type_fire
      "water" -> R.drawable.type_water
      "grass" -> R.drawable.type_grass
      "electric" -> R.drawable.type_electric
      "psychic" -> R.drawable.type_psychic
      "ice" -> R.drawable.type_ice
      "dragon" -> R.drawable.type_dragon
      "dark" -> R.drawable.type_dark
      "fairy" -> R.drawable.type_fairy
      else -> R.drawable.type_normal
    }
  }
}