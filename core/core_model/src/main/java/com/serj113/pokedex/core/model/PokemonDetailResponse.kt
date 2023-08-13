package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDetailResponse(
  @field:Json(name = "id")
  val id: Int = 0,
  @field:Json(name = "order")
  val order: Int = 0,
  @field:Json(name = "String")
  val name: String = "",
  @field:Json(name = "height")
  val height: Int = 0,
  @field:Json(name = "weight")
  val weight: Int = 0,
  @field:Json(name = "base_experience")
  val baseExperience: Int = 0,
  @field:Json(name = "is_default")
  val isDefault: Boolean = false,
  @field:Json(name = "location_area_encounters")
  val locationAreaEncounters: String = "",
  @field:Json(name = "species")
  val species: DataItem = DataItem(),
  @field:Json(name = "stats")
  val stats: List<Stat> = emptyList(),
  @field:Json(name = "types")
  val types: List<Type> = emptyList(),
  @field:Json(name = "abilities")
  val abilities: List<Ability> = emptyList(),
  @field:Json(name = "forms")
  val forms: List<DataItem> = emptyList(),
  @field:Json(name = "game_indices")
  val gameIndices: List<GameIndex> = emptyList(),
  @field:Json(name = "moves")
  val moves: List<Move> = emptyList(),
  // val heldItem
  // val pastTypes
  // val sprites
)