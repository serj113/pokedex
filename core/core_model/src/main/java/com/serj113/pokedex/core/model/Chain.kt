package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Chain(
  @field:Json(name = "is_baby")
  val isBaby: Boolean = false,
  @field:Json(name = "species")
  val species: DataItem = DataItem(),
  @field:Json(name = "evolves_to")
  val evolvesTo: List<Chain> = listOf(),
  @field:Json(name = "evolution_details")
  val evolutionDetails: List<EvolutionDetail> = listOf(),
)