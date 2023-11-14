package com.serj113.pokedex.core.domain.usecase

import arrow.core.Either
import com.serj113.pokedex.core.model.PokemonListResponse

interface GetPokemonListUseCase {
  companion object {
    const val LIMIT = 20
  }

  suspend operator fun invoke(page: Int?): Either<PokemonListResponse, Exception>
}