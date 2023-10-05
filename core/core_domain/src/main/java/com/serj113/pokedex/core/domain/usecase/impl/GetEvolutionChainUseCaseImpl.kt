package com.serj113.pokedex.core.domain.usecase.impl

import com.serj113.pokedex.core.domain.usecase.GetEvolutionChainUseCase
import javax.inject.Inject

class GetEvolutionChainUseCaseImpl @Inject constructor(

): GetEvolutionChainUseCase {
  override suspend fun invoke(id: Int) {
    TODO("Not yet implemented")
  }
}