package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Type(
  @field:Json(name = "slot")
  val slot: Int = 0,
  @field:Json(name = "type")
  val type: DataItem = DataItem(),
)