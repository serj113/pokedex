package com.serj113.pokedex.core.domain.usecase

import arrow.core.Either
import com.serj113.pokedex.core.model.PokemonDetailResponse

interface GetPokemonDetailUseCase {
  suspend operator fun invoke(id: Int): Either<PokemonDetailResponse, Exception>
}