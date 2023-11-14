package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.model.PokemonListResponse
import com.serj113.pokedex.core.model.utils.getPokemonId
import javax.inject.Inject

class GetPokemonListUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
  private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : GetPokemonListUseCase {
  override suspend fun invoke(page: Int?): Either<PokemonListResponse, Exception> {
    val offset = ((page ?: 1) - 1) * GetPokemonListUseCase.LIMIT
    val response = pokemonRepository.fetchPokemonList(offset, GetPokemonListUseCase.LIMIT)
    when (response) {
      is Either.Left -> {
        response.value.results.forEach { pokemon ->
          getPokemonDetailUseCase(pokemon.getPokemonId())
        }
      }

      is Either.Right -> {

      }
    }
    return response
  }
}