package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.GetEvolutionChainUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonSpeciesUseCase
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.EvolutionChainResponse
import com.serj113.pokedex.core.model.utils.getEvolutionChainId
import javax.inject.Inject

class GetEvolutionChainUseCaseImpl @Inject constructor(
  private val pokemonRepository: PokemonRepository,
  private val getPokemonSpeciesUseCase: GetPokemonSpeciesUseCase,
) : GetEvolutionChainUseCase {
  override suspend fun invoke(id: Int): ApiResult<EvolutionChainResponse> {
    return when (val species = getPokemonSpeciesUseCase(id)) {
      is ApiResult.Success -> pokemonRepository.fetchEvolutionChain(
        id = species.value.evolutionChain.getEvolutionChainId()
      )

      is ApiResult.Error -> ApiResult.Error()
    }
  }
}