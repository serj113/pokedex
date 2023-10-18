package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonSpeciesResponse
import javax.inject.Inject

class GetSpeciesUseCaseImpl @Inject constructor(
  private val repository: PokemonRepository,
) : GetSpeciesUseCase {
  override suspend fun invoke(id: Int): ApiResult<PokemonSpeciesResponse> {
    return repository.fetchPokemonSpecies(id)
  }
}