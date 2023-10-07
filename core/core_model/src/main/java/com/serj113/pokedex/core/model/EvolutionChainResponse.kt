package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EvolutionChainResponse(
  @field:Json(name = "id")
  val id: Int = 0,
  @field:Json(name = "chain")
  val chain: Chain = Chain(),
)