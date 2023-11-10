package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetSpeciesUseCase
import com.serj113.pokedex.core.model.PokemonSpeciesResponse
import javax.inject.Inject

class GetSpeciesUseCaseImpl @Inject constructor(
  private val repository: PokemonRepository,
) : GetSpeciesUseCase {
  override suspend fun invoke(id: Int): Either<PokemonSpeciesResponse, Exception> {
    return repository.fetchPokemonSpecies(id)
  }
}