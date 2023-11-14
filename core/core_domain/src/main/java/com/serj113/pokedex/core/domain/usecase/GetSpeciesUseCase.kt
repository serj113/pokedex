package com.serj113.pokedex.core.domain.usecase

import arrow.core.Either
import com.serj113.pokedex.core.model.PokemonSpeciesResponse

interface GetSpeciesUseCase {
  suspend operator fun invoke(id: Int): Either<PokemonSpeciesResponse, Exception>
}