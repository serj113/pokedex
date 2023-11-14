package com.serj113.pokedex.core.domain.usecase

import arrow.core.Either
import com.serj113.pokedex.core.model.EvolutionChainResponse

interface GetEvolutionChainUseCase {
  suspend operator fun invoke(id: Int): Either<EvolutionChainResponse, Exception>
}