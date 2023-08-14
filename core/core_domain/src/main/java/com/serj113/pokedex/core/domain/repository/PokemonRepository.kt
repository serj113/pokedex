package com.serj113.pokedex.core.domain.repository

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import com.serj113.pokedex.core.model.PokemonColorListResponse
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse

interface PokemonRepository {
  suspend fun fetchPokemonList(offset: Int?, limit: Int?): ApiResult<PokemonListResponse>

  suspend fun fetchPokemonDetail(id: Int): ApiResult<PokemonDetailResponse>

  suspend fun fetchPokemonColorList(): ApiResult<PokemonColorListResponse>

  suspend fun fetchPokemonColorDetail(id: Int): ApiResult<PokemonColorDetailResponse>
}