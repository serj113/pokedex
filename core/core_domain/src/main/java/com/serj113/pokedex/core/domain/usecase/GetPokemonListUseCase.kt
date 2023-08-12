package com.serj113.pokedex.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonListResponse

interface GetPokemonListUseCase {
  suspend operator fun invoke(): ApiResult<PokemonListResponse>
}