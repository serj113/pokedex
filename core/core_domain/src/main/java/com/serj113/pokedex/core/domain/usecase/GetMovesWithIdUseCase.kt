package com.serj113.pokedex.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonMoveResponse

interface GetMovesWithIdUseCase {
  suspend operator fun invoke(id: Int): ApiResult<List<PokemonMoveResponse>>
}