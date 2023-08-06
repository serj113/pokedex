package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonColorListResponse(
  @field:Json(name = "count")
  val count: Int = 0,
  @field:Json(name = "next")
  val next: String? = null,
  @field:Json(name = "previous")
  val previous: String? = null,
  @field:Json(name = "results")
  val results: List<DataItem> = emptyList(),
)