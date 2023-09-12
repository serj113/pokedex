package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonMoveResponse(
  @field:Json(name = "id")
  val id: Int = 0,
  @field:Json(name = "name")
  val name: String = "",
  @field:Json(name = "pp")
  val pp: Int = 0,
  @field:Json(name = "type")
  val type: DataItem = DataItem(),
  @field:Json(name = "effect_entries")
  val effectEntries: List<EffectEntry> = listOf(),
)