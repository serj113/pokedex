package com.serj113.pokedex

import android.app.Application
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltAndroidApp
class PokedexApplication: Application() {
  @Inject
  lateinit var pokemonRepository: PokemonRepository

  override fun onCreate() {
    super.onCreate()

    GlobalScope.launch(Dispatchers.IO) {
      pokemonRepository.loadPokemonColor()
    }
  }
}