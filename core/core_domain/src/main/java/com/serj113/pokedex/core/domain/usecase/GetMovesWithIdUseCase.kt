package com.serj113.pokedex.core.domain.usecase

import arrow.core.Either
import com.serj113.pokedex.core.model.PokemonMoveResponse

interface GetMovesWithIdUseCase {
  suspend operator fun invoke(id: Int): Either<List<PokemonMoveResponse>, Exception>
}