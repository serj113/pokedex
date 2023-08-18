package com.serj113.pokedex.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult

interface GetPokemonColorWithPokemonIdUseCase {
  suspend operator fun invoke(id: Int): ApiResult<String>
}