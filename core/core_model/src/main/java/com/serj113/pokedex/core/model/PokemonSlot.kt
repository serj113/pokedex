package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonSlot(
  @field:Json(name = "slot")
  val slot: Int = 0,
  @field:Json(name = "is_hidden")
  val isHidden: Boolean = false,
  @field:Json(name = "pokemon")
  val pokemon: DataItem = DataItem(),
)