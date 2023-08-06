package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonColorDetailResponse(
  @field:Json(name = "id")
  val id: Int = 0,
  @field:Json(name = "String")
  val name: String = "",
  @field:Json(name = "pokemon_species")
  val pokemonSpecies: List<DataItem> = emptyList(),
)