package com.serj113.pokedex.core.data.repository

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.data.service.PokemonService
import com.serj113.pokedex.core.model.ApiResult
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
  private var pokemonMoveHashMap = hashMapOf<Int, PokemonMoveResponse>()

  override suspend fun fetchPokemonList(offset: Int?, limit: Int?): ApiResult<PokemonListResponse> {
    return try {
      val response = service.getPokemonList(offset, limit)
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

  override suspend fun fetchPokemonDetail(id: Int): ApiResult<PokemonDetailResponse> {
    return pokemonDetailHashMap[id]?.let { pokemonDetailResponse ->
      ApiResult.Success(pokemonDetailResponse)
    } ?: run {
      try {
        val response = service.getPokemonDetail(id)
        val body = response.body()
        if (body != null && response.isSuccessful) {
          pokemonDetailHashMap[id] = body
          ApiResult.Success(body)
        } else {
          ApiResult.Error()
        }
      } catch (e: Exception) {
        ApiResult.Error(e)
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

  override suspend fun fetchPokemonSpecies(id: Int): ApiResult<PokemonSpeciesResponse> {
    return pokemonSpeciesHashMap[id]?.let { pokemonSpeciesResponse ->
      ApiResult.Success(pokemonSpeciesResponse)
    } ?: run {
      try {
        val response = service.getPokemonSpecies(id)
        val body = response.body()
        if (body != null && response.isSuccessful) {
          pokemonSpeciesHashMap[id] = body
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

}