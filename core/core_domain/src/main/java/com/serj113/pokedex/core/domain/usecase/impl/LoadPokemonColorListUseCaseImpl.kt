package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.LoadPokemonColorListUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Inject

class LoadPokemonColorListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository
) : LoadPokemonColorListUseCase {

  private var pokemonColorHashMap = ConcurrentHashMap<Int, PokemonColorDetailResponse>()

  override suspend fun invoke() {
    when (val result = pokemonRepository.fetchPokemonColorList()) {
      is ApiResult.Success -> {
        result.value.results.forEach { pokemonColor ->
          val splits = pokemonColor.url.split("/")
          fetchDetail(splits[splits.count() - 2].toInt())
        }
      }
      is ApiResult.Error -> {

      }
    }
  }

  private suspend fun fetchDetail(colorId: Int) {
    when (val result = pokemonRepository.fetchPokemonDetail(colorId)) {
      is ApiResult.Success -> {
        pokemonColorHashMap[colorId] = result.value
      }
      is ApiResult.Error -> {

      }
    }
  }
}