package com.serj113.pokedex.core.data.repository

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.data.service.PokemonService
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.EvolutionChainResponse
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import com.serj113.pokedex.core.model.PokemonColorListResponse
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse
import com.serj113.pokedex.core.model.PokemonMoveResponse
import com.serj113.pokedex.core.model.PokemonSpeciesResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
  private val service: PokemonService,
) : PokemonRepository {

  private val scope = CoroutineScope(Dispatchers.IO)
  private var pokemonColorHashMap = hashMapOf<Int, PokemonColorDetailResponse>()
  private var pokemonDetailHashMap = hashMapOf<Int, PokemonDetailResponse>()
  private var pokemonSpeciesHashMap = hashMapOf<Int, PokemonSpeciesResponse>()
  private var pokemonAbilityHashMap = hashMapOf<Int, PokemonAbilityResponse>()
  private var pokemonMoveHashMap = hashMapOf<Int, PokemonMoveResponse>()
  private var evolutionChainHashMap = hashMapOf<Int, EvolutionChainResponse>()

  override suspend fun fetchPokemonList(offset: Int?, limit: Int?): Either<PokemonListResponse, Exception> {
    return try {
      val response = service.getPokemonList(offset, limit)
      val body = response.body()
      if (body != null && response.isSuccessful) {
        body.left()
      } else {
        Exception(response.message()).right()
      }
    } catch (e: Exception) {
      e.right()
    }
  }

  override suspend fun fetchPokemonDetail(id: Int): Either<PokemonDetailResponse, Exception> {
    return pokemonDetailHashMap[id]?.let { pokemonDetailResponse ->
      pokemonDetailResponse.left()
    } ?: run {
      try {
        val response = service.getPokemonDetail(id)
        val body = response.body()
        if (body != null && response.isSuccessful) {
          pokemonDetailHashMap[id] = body
          body.left()
        } else {
          Exception(response.message()).right()
        }
      } catch (e: Exception) {
        e.right()
      }
    }
  }

  override suspend fun fetchPokemonColorList(): ApiResult<PokemonColorListResponse> {
    return try {
      val response = service.getPokemonColorList()
      val body = response.body()
      if (body != null && response.isSuccessful) {
        ApiResult.Success(body)
      } else {
        ApiResult.Error()
      }
    } catch (e: Exception) {
      ApiResult.Error(e)
    }
  }

  override suspend fun fetchPokemonColorDetail(id: Int): ApiResult<PokemonColorDetailResponse> {
    return try {
      val response = service.getPokemonColorDetail(id)
      val body = response.body()
      if (body != null && response.isSuccessful) {
        ApiResult.Success(body)
      } else {
        ApiResult.Error()
      }
    } catch (e: Exception) {
      ApiResult.Error(e)
    }
  }

  override suspend fun fetchPokemonSpecies(id: Int): Either<PokemonSpeciesResponse, Exception> {
    return pokemonSpeciesHashMap[id]?.let { pokemonSpeciesResponse ->
      pokemonSpeciesResponse.left()
    } ?: run {
      try {
        val response = service.getPokemonSpecies(id)
        val body = response.body()
        if (body != null && response.isSuccessful) {
          pokemonSpeciesHashMap[id] = body
          body.left()
        } else {
          Exception(response.message()).right()
        }
      } catch (e: Exception) {
        e.right()
      }
    }
  }

  override suspend fun fetchPokemonAbility(id: Int): ApiResult<PokemonAbilityResponse> {
    return pokemonAbilityHashMap[id]?.let { pokemonAbilityResponse ->
      ApiResult.Success(pokemonAbilityResponse)
    } ?: run {
      try {
        val response = service.getPokemonAbility(id)
        val body = response.body()
        if (body != null && response.isSuccessful) {
          pokemonAbilityHashMap[id] = body
          ApiResult.Success(body)
        } else {
          ApiResult.Error()
        }
      } catch (e: Exception) {
        ApiResult.Error(e)
      }
    }
  }

  override suspend fun fetchPokemonMove(id: Int): ApiResult<PokemonMoveResponse> {
    return pokemonMoveHashMap[id]?.let { pokemonMoveResponse ->
      ApiResult.Success(pokemonMoveResponse)
    } ?: run {
      try {
        val response = service.getPokemonMove(id)
        val body = response.body()
        if (body != null && response.isSuccessful) {
          pokemonMoveHashMap[id] = body
          ApiResult.Success(body)
        } else {
          ApiResult.Error()
        }
      } catch (e: Exception) {
        ApiResult.Error(e)
      }
    }
  }

  override suspend fun loadPokemonColor() {
    when (val result = fetchPokemonColorList()) {
      is ApiResult.Success -> {
        result.value.results.forEach { pokemonColor ->
          val splits = pokemonColor.url.split("/")
          scope.launch {
            val colorId = splits[splits.count() - 2].toInt()
            when (val detailResult = fetchPokemonColorDetail(colorId)) {
              is ApiResult.Success -> {
                pokemonColorHashMap[colorId] = detailResult.value
              }
              is ApiResult.Error -> {

              }
            }
          }
        }
      }

      is ApiResult.Error -> {

      }
    }
  }

  override suspend fun fetchEvolutionChain(id: Int): ApiResult<EvolutionChainResponse> {
    return evolutionChainHashMap[id]?.let { response ->
      ApiResult.Success(response)
    } ?: run {
      try {
        val response = service.getEvolutionChain(id)
        val body = response.body()
        if (body != null && response.isSuccessful) {
          evolutionChainHashMap[id] = body
          ApiResult.Success(body)
        } else {
          ApiResult.Error()
        }
      } catch (e: Exception) {
        ApiResult.Error(e)
      }
    }
  }

}