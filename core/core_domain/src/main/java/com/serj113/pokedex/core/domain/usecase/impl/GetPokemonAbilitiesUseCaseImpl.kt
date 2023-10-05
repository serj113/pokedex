package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetPokemonAbilitiesUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.utils.getAbilityId
import javax.inject.Inject

class GetPokemonAbilitiesUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
  private val getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : GetPokemonAbilitiesUseCase {
  override suspend fun invoke(id: Int): ApiResult<List<PokemonAbilityResponse>> {
    val moves = mutableListOf<PokemonAbilityResponse>()
    when (val pokemonDetail = getPokemonDetailUseCase(id)) {
      is ApiResult.Success -> {
        moves.addAll(
          pokemonDetail.value.abilities
            .map { ability ->
              pokemonRepository.fetchPokemonAbility(ability.ability.getAbilityId())
            }
            .filterIsInstance<ApiResult.Success<PokemonAbilityResponse>>()
            .map { abilityDetail -> abilityDetail.value }
        )
      }

      is ApiResult.Error -> { }
    }

    return ApiResult.Success(moves)
  }
}