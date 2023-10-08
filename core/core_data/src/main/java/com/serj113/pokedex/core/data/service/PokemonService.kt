package com.serj113.pokedex.core.data.service

import com.serj113.pokedex.core.model.EvolutionChainResponse
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import com.serj113.pokedex.core.model.PokemonColorListResponse
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse
import com.serj113.pokedex.core.model.PokemonMoveResponse
import com.serj113.pokedex.core.model.PokemonSpeciesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
  companion object {
    private const val POKEMON_LIST = "pokemon"
    private const val POKEMON_DETAIL = "pokemon/{id}"
    private const val POKEMON_COLOR_LIST = "pokemon-color"
    private const val POKEMON_COLOR_DETAIL = "pokemon-color/{id}"
    private const val POKEMON_SPECIES_DETAIL = "pokemon-species/{id}"
    private const val POKEMON_ABILITY_DETAIL = "ability/{id}"
    private const val POKEMON_MOVE_DETAIL = "move/{id}"
    private const val EVOLUTION_CHAIN = "evolution-chain/{id}"
  }

  @GET(POKEMON_LIST)
  suspend fun getPokemonList(
    @Query("offset") offset: Int? = null,
    @Query("limit") limit: Int? = null,
  ): Response<PokemonListResponse>

  @GET(POKEMON_DETAIL)
  suspend fun getPokemonDetail(
    @Path("id") id: Int,
  ): Response<PokemonDetailResponse>

  @GET(POKEMON_COLOR_LIST)
  suspend fun getPokemonColorList(): Response<PokemonColorListResponse>

  @GET(POKEMON_COLOR_DETAIL)
  suspend fun getPokemonColorDetail(
    @Path("id") id: Int,
  ): Response<PokemonColorDetailResponse>

  @GET(POKEMON_SPECIES_DETAIL)
  suspend fun getPokemonSpecies(
    @Path("id") id: Int,
  ): Response<PokemonSpeciesResponse>

  @GET(POKEMON_ABILITY_DETAIL)
  suspend fun getPokemonAbility(
    @Path("id") id: Int,
  ): Response<PokemonAbilityResponse>

  @GET(POKEMON_MOVE_DETAIL)
  suspend fun getPokemonMove(
    @Path("id") id: Int,
  ): Response<PokemonMoveResponse>

  @GET(EVOLUTION_CHAIN)
  suspend fun getEvolutionChain(
    @Path("id") id: Int,
  ): Response<EvolutionChainResponse>
}