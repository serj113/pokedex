package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EffectEntry(
  @field:Json(name = "effect")
  val effect: String = "",
  @field:Json(name = "short_effect")
  val shortEffect: String = "",
  @field:Json(name = "language")
  val language: DataItem = DataItem(),
)