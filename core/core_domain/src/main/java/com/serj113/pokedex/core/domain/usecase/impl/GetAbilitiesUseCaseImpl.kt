package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetAbilitiesUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.utils.getAbilityId
import javax.inject.Inject

class GetAbilitiesUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
  private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : GetAbilitiesUseCase {
  override suspend fun invoke(id: Int): ApiResult<List<PokemonAbilityResponse>> {
    val moves = mutableListOf<PokemonAbilityResponse>()
    when (val pokemonDetail = getPokemonDetailUseCase(id)) {
      is Either.Left -> {
        moves.addAll(
          pokemonDetail.value.abilities
            .map { ability ->
              pokemonRepository.fetchPokemonAbility(ability.ability.getAbilityId())
            }
            .filterIsInstance<ApiResult.Success<PokemonAbilityResponse>>()
            .map { abilityDetail -> abilityDetail.value }
        )
      }
      is Either.Right -> {}
    }

    return ApiResult.Success(moves)
  }
}