package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetPokemonSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonSpeciesResponse
import javax.inject.Inject

class GetPokemonSpeciesUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetPokemonSpeciesUseCase {
  override suspend fun invoke(id: Int): ApiResult<PokemonSpeciesResponse> {
    TODO("Not yet implemented")
  }
}