package com.serj113.pokedex.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorListResponse

interface GetColorListUseCase {
  suspend operator fun invoke(): ApiResult<PokemonColorListResponse>
}