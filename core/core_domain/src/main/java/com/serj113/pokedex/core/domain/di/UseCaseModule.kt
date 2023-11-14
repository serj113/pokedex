package com.serj113.pokedex.core.domain.di

import com.serj113.pokedex.core.domain.usecase.GetAbilitiesUseCase
import com.serj113.pokedex.core.domain.usecase.GetColorWithIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetColorWithSpeciesIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetEvolutionChainUseCase
import com.serj113.pokedex.core.domain.usecase.GetMovesWithIdUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.domain.usecase.GetSpeciesUseCase
import com.serj113.pokedex.core.domain.usecase.impl.GetAbilitiesUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetColorWithIdUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetColorWithSpeciesIdUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetEvolutionChainUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetMovesWithIdUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetPokemonDetailUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetPokemonListUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetSpeciesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {

  @Binds
  @Singleton
  internal abstract fun provideGetPokemonListUseCase(
    getPokemonListUseCaseImpl: GetPokemonListUseCaseImpl
  ): GetPokemonListUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetPokemonDetailUseCase(
    getPokemonDetailUseCaseImpl: GetPokemonDetailUseCaseImpl
  ): GetPokemonDetailUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetSpeciesUseCase(
    getSpeciesUseCaseImpl: GetSpeciesUseCaseImpl
  ): GetSpeciesUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetColorWithIdUseCase(
    getColorWithIdUseCaseImpl: GetColorWithIdUseCaseImpl
  ): GetColorWithIdUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetColorWithSpeciesIdUseCase(
    getColorWithSpeciesIdUseCaseImpl: GetColorWithSpeciesIdUseCaseImpl
  ): GetColorWithSpeciesIdUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetMovesWithIdUseCase(
    getMovesWithIdUseCaseImpl: GetMovesWithIdUseCaseImpl
  ): GetMovesWithIdUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetAbilitiesUseCase(
    getAbilitiesUseCaseImpl: GetAbilitiesUseCaseImpl
  ): GetAbilitiesUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetEvolutionChainUseCase(
    getEvolutionChainUseCaseImpl: GetEvolutionChainUseCaseImpl
  ): GetEvolutionChainUseCase
}