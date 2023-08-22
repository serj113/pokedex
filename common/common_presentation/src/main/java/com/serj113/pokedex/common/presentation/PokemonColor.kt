package com.serj113.pokedex.common.presentation

import androidx.compose.ui.graphics.Color

object PokemonColor {
  fun getComposeColor(webColor: String): Color {
    return when (webColor) {
      "black" -> ComposeColor.black
      "blue" -> ComposeColor.blue
      "brown" -> ComposeColor.brown
      "gray" -> ComposeColor.gray
      "green" -> ComposeColor.green
      "pink" -> ComposeColor.pink
      "purple" -> ComposeColor.purple
      "red" -> ComposeColor.red
      "yellow" -> ComposeColor.yellow
      else -> ComposeColor.white
    }
  }
}