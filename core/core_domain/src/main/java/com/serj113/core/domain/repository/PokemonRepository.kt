package com.serj113.core.domain.repository

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse

interface PokemonRepository {
  suspend fun fetchPokemonList(): ApiResult<PokemonListResponse>

  suspend fun fetchPokemonDetail(id: Int): ApiResult<PokemonDetailResponse>
}