package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonSpeciesResponse(
  @field:Json(name = "id")
  val id: Int = 0,
  @field:Json(name = "name")
  val name: String = "",
  @field:Json(name = "order")
  val order: Int = 0,
  @field:Json(name = "base_happiness")
  val baseHappiness: Int = 0,
  @field:Json(name = "capture_rate")
  val captureRate: Int = 0,
  @field:Json(name = "forms_switchable")
  val formsSwitchable: Boolean = false,
  @field:Json(name = "is_baby")
  val isBaby: Boolean = false,
  @field:Json(name = "is_legendary")
  val isLegendary: Boolean = false,
  @field:Json(name = "is_mythical")
  val isMythical: Boolean = false,
  @field:Json(name = "gender_rate")
  val genderRate: Int = 0,
  @field:Json(name = "color")
  val color: DataItem = DataItem(),
  @field:Json(name = "generation")
  val generation: DataItem = DataItem(),
  @field:Json(name = "growth_rate")
  val growthRate: DataItem = DataItem(),
  @field:Json(name = "habitat")
  val habitat: DataItem = DataItem(),
  @field:Json(name = "evolution_chain")
  val evolutionChain: UrlItem = UrlItem(),
  @field:Json(name = "evolves_from_species")
  val evolvesFromSpecies: DataItem? = null,
  @field:Json(name = "egg_groups")
  val eggGroups: List<DataItem> = listOf(),
  @field:Json(name = "flavor_text_entries")
  val flavorTextEntries: List<FlavorTextEntry> = listOf(),
  @field:Json(name = "genera")
  val genera: List<Genera> = listOf(),
)