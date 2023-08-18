package com.serj113.pokedex.core.domain.di

import com.serj113.pokedex.core.domain.usecase.GetPokemonColorDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonColorListUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonDetailUseCase
import com.serj113.pokedex.core.domain.usecase.GetPokemonListUseCase
import com.serj113.pokedex.core.domain.usecase.impl.GetPokemonColorDetailUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetPokemonColorListUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetPokemonDetailUseCaseImpl
import com.serj113.pokedex.core.domain.usecase.impl.GetPokemonListUseCaseImpl
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
  internal abstract fun provideGetPokemonColorListUseCase(
    getPokemonColorListUseCaseImpl: GetPokemonColorListUseCaseImpl
  ): GetPokemonColorListUseCase

  @Binds
  @Singleton
  internal abstract fun provideGetPokemonColorDetailUseCase(
    getPokemonColorDetailUseCaseImpl: GetPokemonColorDetailUseCaseImpl
  ): GetPokemonColorDetailUseCase
}