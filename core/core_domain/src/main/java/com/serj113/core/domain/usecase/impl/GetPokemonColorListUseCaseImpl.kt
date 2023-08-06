package com.serj113.core.domain.usecase.impl

import com.serj113.core.domain.repository.PokemonRepository
import com.serj113.core.domain.usecase.GetPokemonColorListUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorListResponse
import javax.inject.Inject

class GetPokemonColorListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetPokemonColorListUseCase {
  override suspend fun invoke(): ApiResult<PokemonColorListResponse> {
    return pokemonRepository.fetchPokemonColorList()
  }
}