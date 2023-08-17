package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.LoadPokemonColorListUseCase
import com.serj113.pokedex.core.model.ApiResult
import javax.inject.Inject

class LoadPokemonColorListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository
) : LoadPokemonColorListUseCase {



  override suspend fun invoke() {
    when (val result = pokemonRepository.fetchPokemonColorList()) {
      is ApiResult.Success -> {
        result.value.results.forEach { pokemonColor ->

        }
      }
      is ApiResult.Error -> {

      }
    }
  }
}