package com.serj113.pokedex.core.domain.usecase.impl

import arrow.core.Either
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetEvolutionChainUseCase
import com.serj113.pokedex.core.domain.usecase.GetSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.EvolutionChainResponse
import com.serj113.pokedex.core.model.utils.getEvolutionChainId
import javax.inject.Inject

class GetEvolutionChainUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
  private val getPokemonSpeciesUseCase: GetSpeciesUseCase,
) : GetEvolutionChainUseCase {
  override suspend fun invoke(id: Int): ApiResult<EvolutionChainResponse> {
    return when (val species = getPokemonSpeciesUseCase(id)) {
      is Either.Left -> pokemonRepository.fetchEvolutionChain(
        id = species.value.evolutionChain.getEvolutionChainId()
      )

      is Either.Right -> ApiResult.Error()
    }
  }
}