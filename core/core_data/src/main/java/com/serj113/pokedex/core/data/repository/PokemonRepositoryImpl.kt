package com.serj113.pokedex.core.data.repository

import com.serj113.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.data.service.PokemonService
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonListResponse
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
  private val service: PokemonService,
) : PokemonRepository {
  override suspend fun fetchPokemonList(): ApiResult<PokemonListResponse> {
    TODO("Not yet implemented")
  }

}