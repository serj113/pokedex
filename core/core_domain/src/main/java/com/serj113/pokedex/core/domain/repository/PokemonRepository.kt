package com.serj113.pokedex.core.domain.repository

import arrow.core.Either
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

  suspend fun fetchPokemonList(offset: Int?, limit: Int?): Either<PokemonListResponse, Exception>

  suspend fun fetchPokemonDetail(id: Int): Either<PokemonDetailResponse, Exception>

  suspend fun fetchPokemonColorList(): ApiResult<PokemonColorListResponse>

  suspend fun fetchPokemonColorDetail(id: Int): ApiResult<PokemonColorDetailResponse>

  suspend fun fetchPokemonSpecies(id: Int): Either<PokemonSpeciesResponse, Exception>

  suspend fun fetchPokemonAbility(id: Int): Either<PokemonAbilityResponse, Exception>

  suspend fun fetchPokemonMove(id: Int): Either<PokemonMoveResponse, Exception>

  suspend fun loadPokemonColor()

  suspend fun fetchEvolutionChain(id: Int): Either<EvolutionChainResponse, Exception>
}