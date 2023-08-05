package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GameIndex(
  @field:Json(name = "game_index")
  val gameIndex: Int = 0,
  @field:Json(name = "version")
  val version: DataItem = DataItem(),
)