package com.serj113.core.domain.usecase.impl

import com.serj113.core.domain.repository.PokemonRepository
import com.serj113.core.domain.usecase.GetPokemonColorDetailUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import javax.inject.Inject

class GetPokemonColorDetailUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetPokemonColorDetailUseCase {
  override suspend fun invoke(id: Int): ApiResult<PokemonColorDetailResponse> {
    return pokemonRepository.fetchPokemonColorDetail(id)
  }
}