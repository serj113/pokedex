package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonListResponse
import javax.inject.Inject

class GetPokemonListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
) : GetPokemonListUseCase {
  override suspend fun invoke(page: Int?): ApiResult<PokemonListResponse> {
    val offset = ((page ?: 1) - 1) * GetPokemonListUseCase.LIMIT
    return pokemonRepository.fetchPokemonList(offset, GetPokemonListUseCase.LIMIT)
  }
}