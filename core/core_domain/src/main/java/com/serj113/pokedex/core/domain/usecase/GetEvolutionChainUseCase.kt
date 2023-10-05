package com.serj113.pokedex.core.domain.usecase

interface GetEvolutionChainUseCase {
  suspend operator fun invoke(id: Int)
}