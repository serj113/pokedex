package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
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
  override suspend fun invoke(id: Int): ApiResult<List<PokemonMoveResponse>> {
    val moves = mutableListOf<PokemonMoveResponse>()
    when (val pokemonDetail = getPokemonDetailUseCase(id)) {
      is Either.Left -> {
        moves.addAll(
          pokemonDetail.value.moves
            .map { move ->
              pokemonRepository.fetchPokemonMove(move.move.getMoveId())
            }
            .filterIsInstance<ApiResult.Success<PokemonMoveResponse>>()
            .map { moveDetail -> moveDetail.value }
        )
      }

      is Either.Right -> {}
    }

    return ApiResult.Success(moves)
  }
}