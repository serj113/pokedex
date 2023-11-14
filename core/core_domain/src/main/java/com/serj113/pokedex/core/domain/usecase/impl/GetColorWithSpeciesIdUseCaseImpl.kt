package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import com.serj113.pokedex.core.domain.usecase.GetColorWithSpeciesIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import javax.inject.Inject

class GetColorWithSpeciesIdUseCaseImpl @Inject constructor(
  private val getPokemonSpeciesUseCase: GetSpeciesUseCase,
) : GetColorWithSpeciesIdUseCase {
  override suspend fun invoke(id: Int): ApiResult<String> {
    return when (val speciesResult = getPokemonSpeciesUseCase(id)) {
      is Either.Left -> {
        ApiResult.Success(speciesResult.value.color.name)
      }

      is Either.Right -> ApiResult.Error()
    }
  }
}