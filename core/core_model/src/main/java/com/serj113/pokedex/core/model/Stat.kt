package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Stat(
  @field:Json(name = "base_stat")
  val baseStat: Int = 0,
  @field:Json(name = "effort")
  val effort: Int = 0,
  @field:Json(name = "stat")
  val stat: DataItem = DataItem(),
)