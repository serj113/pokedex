package com.serj113.core.domain.usecase.impl

import com.serj113.pokedex.core.model.UseCaseResult
import com.serj113.core.domain.repository.PokemonRepository
import com.serj113.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.model.PokemonListResponse
import javax.inject.Inject

class GetPokemonListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetPokemonListUseCase {
  override suspend fun invoke(): UseCaseResult<PokemonListResponse> {
    TODO("Not yet implemented")
  }
}