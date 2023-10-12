package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetColorDetailUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import javax.inject.Inject

class GetColorDetailUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetColorDetailUseCase {
  override suspend fun invoke(id: Int): ApiResult<PokemonColorDetailResponse> {
    return pokemonRepository.fetchPokemonColorDetail(id)
  }
}