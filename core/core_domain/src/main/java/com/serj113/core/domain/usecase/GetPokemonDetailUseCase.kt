package com.serj113.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonDetailResponse

interface GetPokemonDetailUseCase {
  suspend operator fun invoke(id: Int): ApiResult<PokemonDetailResponse>
}