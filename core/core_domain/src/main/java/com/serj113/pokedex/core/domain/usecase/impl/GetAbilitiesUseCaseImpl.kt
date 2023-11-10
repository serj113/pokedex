package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import arrow.core.left
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
  override suspend fun invoke(id: Int): Either<List<PokemonAbilityResponse>, Exception> {
    return when (val pokemonDetail = getPokemonDetailUseCase(id)) {
      is Either.Left -> {
        pokemonDetail.value.abilities
          .map { ability ->
            pokemonRepository.fetchPokemonAbility(ability.ability.getAbilityId())
          }
          .filterIsInstance<Either.Left<PokemonAbilityResponse>>()
          .map { abilityDetail -> abilityDetail.value }
          .left()
      }
      is Either.Right -> pokemonDetail
    }
  }
}