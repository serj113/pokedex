package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetMovesWithIdUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonMoveResponse
import com.serj113.pokedex.core.model.utils.getMoveId
import javax.inject.Inject

class GetMovesWithIdUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
  private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : GetMovesWithIdUseCase {
  override suspend fun invoke(id: Int): Either<List<PokemonMoveResponse>, Exception> {
    return when (val pokemonDetail = getPokemonDetailUseCase(id)) {
      is Either.Left -> {
        pokemonDetail.value.moves
          .map { move ->
            pokemonRepository.fetchPokemonMove(move.move.getMoveId())
          }
          .filterIsInstance<Either.Left<PokemonMoveResponse>>()
          .map { moveDetail -> moveDetail.value }
          .left()
      }

      is Either.Right -> pokemonDetail
    }
  }
}