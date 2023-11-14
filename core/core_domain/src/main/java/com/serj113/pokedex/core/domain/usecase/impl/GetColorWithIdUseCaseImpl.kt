package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import com.serj113.pokedex.core.domain.usecase.GetColorWithIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetColorWithSpeciesIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.utils.getSpeciesId
import javax.inject.Inject

class GetColorWithIdUseCaseImpl @Inject constructor(
  private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
  private val getPokemonColorWithSpeciesIdUseCase: GetColorWithSpeciesIdUseCase,
) : GetColorWithIdUseCase {
  override suspend fun invoke(id: Int): ApiResult<String> {
    return when (val detailResult = getPokemonDetailUseCase(id)) {
      is Either.Left -> {
        getPokemonColorWithSpeciesIdUseCase(detailResult.value.species.getSpeciesId())
      }
      is Either.Right -> ApiResult.Error()
    }
  }
}