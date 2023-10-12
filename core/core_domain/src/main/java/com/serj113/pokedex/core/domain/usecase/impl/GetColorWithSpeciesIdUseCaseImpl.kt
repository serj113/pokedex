package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.usecase.GetColorWithSpeciesIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import javax.inject.Inject

class GetColorWithSpeciesIdUseCaseImpl @Inject constructor(
  private val getPokemonSpeciesUseCase: GetSpeciesUseCase,
): GetColorWithSpeciesIdUseCase {
  override suspend fun invoke(id: Int): ApiResult<String> {
    return when (val speciesResult = getPokemonSpeciesUseCase(id)) {
      is ApiResult.Success -> {
        ApiResult.Success(speciesResult.value.color.name)
      }
      is ApiResult.Error -> ApiResult.Error()
    }
  }
}