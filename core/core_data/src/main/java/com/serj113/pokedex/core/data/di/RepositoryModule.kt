package com.serj113.pokedex.core.data.di

import com.serj113.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.data.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

  @Binds
  @Singleton
  internal abstract fun providePokemonRepository(
    pokemonRepositoryImpl: PokemonRepositoryImpl
  ): PokemonRepository
}