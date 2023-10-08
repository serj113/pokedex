package com.serj113.pokedex.core.model.utils

object Urls {
  private const val BASE_SPRITE_IMAGE = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"
  private const val SPRITE_IMAGE_EXTENSION = ".png"

  fun getSpriteImage(id: Int): String {
    return "$BASE_SPRITE_IMAGE$id$SPRITE_IMAGE_EXTENSION"
  }
}