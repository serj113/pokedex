package com.serj113.core.domain.di

import com.serj113.core.domain.usecase.GetPokemonListUseCase
import com.serj113.core.domain.usecase.impl.GetPokemonListUseCaseImpl
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
}