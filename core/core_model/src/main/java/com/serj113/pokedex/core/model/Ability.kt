package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Ability(
  @field:Json(name = "ability")
  val ability: DataItem = DataItem(),
  @field:Json(name = "is_hidden")
  val isHidden: Boolean = false,
  @field:Json(name = "slot")
  val slot: Int = 0,
)