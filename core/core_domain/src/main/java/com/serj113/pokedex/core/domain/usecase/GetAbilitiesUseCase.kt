package com.serj113.pokedex.core.domain.usecase

import arrow.core.Either
import com.serj113.pokedex.core.model.PokemonAbilityResponse

interface GetAbilitiesUseCase {
  suspend operator fun invoke(id: Int): Either<List<PokemonAbilityResponse>, Exception>
}