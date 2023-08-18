package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class FlavorTextEntry(
  @field:Json(name = "flavor_text")
  val flavorText: String = "",
  @field:Json(name = "language")
  val language: DataItem = DataItem(),
  @field:Json(name = "version")
  val version: DataItem = DataItem(),
)