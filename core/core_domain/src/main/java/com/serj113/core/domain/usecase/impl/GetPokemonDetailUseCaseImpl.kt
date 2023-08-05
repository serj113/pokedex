package com.serj113.core.domain.usecase.impl

import com.serj113.core.domain.repository.PokemonRepository
import com.serj113.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonDetailResponse
import javax.inject.Inject

class GetPokemonDetailUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetPokemonDetailUseCase {
  override suspend fun invoke(id: Int): ApiResult<PokemonDetailResponse> {
    return pokemonRepository.fetchPokemonDetail(id)
  }
}