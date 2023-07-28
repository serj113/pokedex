package com.serj113.core.domain.usecase

import com.serj113.pokedex.core.model.UseCaseResult
import com.serj113.pokedex.core.model.PokemonListResponse

interface GetPokemonListUseCase {
  suspend operator fun invoke(): UseCaseResult<PokemonListResponse>
}