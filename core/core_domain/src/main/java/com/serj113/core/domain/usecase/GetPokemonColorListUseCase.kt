package com.serj113.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorListResponse

interface GetPokemonColorListUseCase {
  suspend operator fun invoke(): ApiResult<PokemonColorListResponse>
}