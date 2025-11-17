package com.serj113.pokedex.core.model.utils

import android.util.Log

object Urls {
  private const val BASE_SPRITE_IMAGE = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"
  private const val SPRITE_IMAGE_EXTENSION = ".png"

  fun getSpriteImage(id: Int): String {
      val image = "$BASE_SPRITE_IMAGE$id$SPRITE_IMAGE_EXTENSION"
      Log.d("Point Debug", image)
    return "$BASE_SPRITE_IMAGE$id$SPRITE_IMAGE_EXTENSION"
  }
}