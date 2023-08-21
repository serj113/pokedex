package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.usecase.GetPokemonColorWithSpeciesIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import javax.inject.Inject

class GetPokemonColorWithSpeciesIdUseCaseImpl @Inject constructor(
  private val getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase,
): GetPokemonColorWithSpeciesIdUseCase {
  override suspend fun invoke(id: Int): ApiResult<String> {
    return when (val speciesResult = getPokemonSpeciesUseCase(id)) {
      is ApiResult.Success -> {
        ApiResult.Success(speciesResult.value.color.name)
      }
      is ApiResult.Error -> ApiResult.Error()
    }
  }
}