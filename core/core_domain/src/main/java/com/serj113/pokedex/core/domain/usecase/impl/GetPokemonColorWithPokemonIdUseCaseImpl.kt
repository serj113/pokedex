package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.usecase.GetPokemonColorWithPokemonIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.utils.getSpeciesId
import javax.inject.Inject

class GetPokemonColorWithPokemonIdUseCaseImpl @Inject constructor(
  private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
  private val getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase,
) : GetPokemonColorWithPokemonIdUseCase {
  override suspend fun invoke(id: Int): ApiResult<String> {
    return when (val detailResult = getPokemonDetailUseCase(id)) {
      is ApiResult.Success -> {
        when (val speciesResult = getPokemonSpeciesUseCase(detailResult.value.species.getSpeciesId())) {
          is ApiResult.Success -> {
            ApiResult.Success(speciesResult.value.color.name)
          }
          is ApiResult.Error -> ApiResult.Error()
        }
      }
      is ApiResult.Error -> ApiResult.Error()
    }
  }
}