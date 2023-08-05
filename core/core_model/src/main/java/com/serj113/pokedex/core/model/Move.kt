package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Move(
  @field:Json(name = "move")
  val move: DataItem = DataItem(),
  @field:Json(name = "version_group_details")
  val versionGroupDetail: List<MoveVersionGroupDetail> = emptyList(),
)