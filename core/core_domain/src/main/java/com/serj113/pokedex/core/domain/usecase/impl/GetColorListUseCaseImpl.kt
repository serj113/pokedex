package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetColorListUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonColorListResponse
import javax.inject.Inject

class GetColorListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetColorListUseCase {
  override suspend fun invoke(): ApiResult<PokemonColorListResponse> {
    return pokemonRepository.fetchPokemonColorList()
  }
}