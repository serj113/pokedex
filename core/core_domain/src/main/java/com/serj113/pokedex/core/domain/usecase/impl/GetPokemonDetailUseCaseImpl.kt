package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.model.PokemonDetailResponse
import javax.inject.Inject

class GetPokemonDetailUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetPokemonDetailUseCase {
  override suspend fun invoke(id: Int): Either<PokemonDetailResponse, Exception> {
    return pokemonRepository.fetchPokemonDetail(id)
  }
}