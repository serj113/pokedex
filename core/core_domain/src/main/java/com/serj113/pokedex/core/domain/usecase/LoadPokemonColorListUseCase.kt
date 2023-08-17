package com.serj113.pokedex.core.domain.usecase

interface LoadPokemonColorListUseCase {
  suspend operator fun invoke()
}