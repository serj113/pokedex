package com.serj113.pokedex.common.presentation

import androidx.compose.ui.graphics.Color

object PokemonType {

  val normal = Color(0xFFA8A77A)
  val fighting = Color(0xFFC22E28)
  val flying = Color(0xFFA98FF3)
  val poison = Color(0xFFA33EA1)
  val ground = Color(0xFFE2BF65)
  val rock = Color(0xFFB6A136)
  val bug = Color(0xFFA6B91A)
  val ghost = Color(0xFF735797)
  val steel = Color(0xFFB7B7CE)
  val fire = Color(0xFFEE8130)
  val water = Color(0xFF6390F0)
  val grass = Color(0xFF7AC74C)
  val electric = Color(0xFFF7D02C)
  val psychic = Color(0xFFF95587)
  val ice = Color(0xFF96D9D6)
  val dragon = Color(0xFF6F35FC)
  val dark = Color(0xFF705746)
  val fairy = Color(0xFFD685AD)

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

  fun getTypeColor(type: String): Color {
    return when (type) {
      "normal" -> normal
      "fighting" -> fighting
      "flying" -> flying
      "poison" -> poison
      "ground" -> ground
      "rock" -> rock
      "bug" -> bug
      "ghost" -> ghost
      "steel" -> steel
      "fire" -> fire
      "water" -> water
      "grass" -> grass
      "electric" -> electric
      "psychic" -> psychic
      "ice" -> ice
      "dragon" -> dragon
      "dark" -> dark
      "fairy" -> fairy
      else -> normal
    }
  }
}