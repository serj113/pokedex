package com.serj113.pokedex.core.data.service

import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonService {
  companion object {
    private const val POKEMON_LIST = "pokemon"
    private const val POKEMON_DETAIL = "pokemon/{id}"
  }

  @GET(POKEMON_LIST)
  suspend fun getPokemonList(
    @Query("offset") offset: Int,
    @Query("limit") limit: Int,
  ): Response<PokemonListResponse>

  @GET(POKEMON_DETAIL)
  suspend fun getPokemonDetail(
    @Path("id") id: Int,
  ): Response<PokemonDetailResponse>
}