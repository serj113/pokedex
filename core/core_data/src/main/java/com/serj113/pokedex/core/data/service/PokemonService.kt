package com.serj113.pokedex.core.data.service

import com.serj113.pokedex.core.model.PokemonListResponse
import retrofit2.Response
import retrofit2.http.GET

interface PokemonService {
  companion object {
    private const val POKEMON_LIST = "pokemon"
  }

  @GET(POKEMON_LIST)
  suspend fun getPokemonList(): Response<PokemonListResponse>
  
}