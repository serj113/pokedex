package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolutionDetail(
  @field:Json(name = "trigger")
  val trigger: DataItem = DataItem(),
)