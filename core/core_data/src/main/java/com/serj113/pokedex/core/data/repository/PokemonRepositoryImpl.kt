package com.serj113.pokedex.core.data.repository

import com.serj113.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.data.service.PokemonService
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import com.serj113.pokedex.core.model.PokemonColorListResponse
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
  private val service: PokemonService,
) : PokemonRepository {
  override suspend fun fetchPokemonList(): ApiResult<PokemonListResponse> {
    return try {
      val response = service.getPokemonList()
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
    return try {
      val response = service.getPokemonDetail(id)
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

}