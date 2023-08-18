package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Genera(
  @field:Json(name = "genus")
  val genus: String = "",
  @field:Json(name = "language")
  val language: DataItem = DataItem(),
)