package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MoveVersionGroupDetail(
  @field:Json(name = "level_learned_at")
  val levelLearnedAt: Int = 0,
  @field:Json(name = "move_learn_method")
  val moveLearnMethod: DataItem = DataItem(),
  @field:Json(name = "version_group")
  val versionGroup: DataItem = DataItem(),
)