package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonListResponse
import com.serj113.pokedex.core.model.utils.getPokemonId
import javax.inject.Inject

class GetPokemonListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
  private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : GetPokemonListUseCase {
  override suspend fun invoke(page: Int?): ApiResult<PokemonListResponse> {
    val offset = ((page ?: 1) - 1) * GetPokemonListUseCase.LIMIT
    val response = pokemonRepository.fetchPokemonList(offset, GetPokemonListUseCase.LIMIT)
    when (response) {
      is ApiResult.Success -> {
        response.value.results.forEach { pokemon ->
          getPokemonDetailUseCase(pokemon.getPokemonId())
        }
      }
      is ApiResult.Error -> {

      }
    }
    return response
  }
}