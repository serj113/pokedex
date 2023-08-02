package com.serj113.pokedex.core.data.di

import com.serj113.pokedex.core.data.service.PokemonService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServiceModule {

  @Provides
  @Singleton
  internal fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient()
  }

  @Provides
  @Singleton
  internal fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
      .baseUrl("https://pokeapi.co/api/v2/")
      .client(okHttpClient)
      .addConverterFactory(MoshiConverterFactory.create())
      .build()
  }

  @Provides
  @Singleton
  internal fun providePokemonService(retrofit: Retrofit): PokemonService {
    return retrofit.create(PokemonService::class.java)
  }
}