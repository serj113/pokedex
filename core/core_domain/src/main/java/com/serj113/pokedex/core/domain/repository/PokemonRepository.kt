package com.serj113.pokedex.core.domain.repository

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.EvolutionChainResponse
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import com.serj113.pokedex.core.model.PokemonColorListResponse
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse
import com.serj113.pokedex.core.model.PokemonMoveResponse
import com.serj113.pokedex.core.model.PokemonSpeciesResponse

interface PokemonRepository {
  suspend fun fetchPokemonList(offset: Int?, limit: Int?): ApiResult<PokemonListResponse>

  suspend fun fetchPokemonDetail(id: Int): ApiResult<PokemonDetailResponse>

  suspend fun fetchPokemonColorList(): ApiResult<PokemonColorListResponse>

  suspend fun fetchPokemonColorDetail(id: Int): ApiResult<PokemonColorDetailResponse>

  suspend fun fetchPokemonSpecies(id: Int): ApiResult<PokemonSpeciesResponse>

  suspend fun fetchPokemonAbility(id: Int): ApiResult<PokemonAbilityResponse>

  suspend fun fetchPokemonMove(id: Int): ApiResult<PokemonMoveResponse>

  suspend fun loadPokemonColor()

  suspend fun fetchEvolutionChain(id: Int): ApiResult<EvolutionChainResponse>
}