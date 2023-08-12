package com.serj113.pokedex.feature.pokemonlist.ui

import com.serj113.pokedex.feature.pokemonlist.data.PokemonList
import kotlinx.coroutines.channels.Channel

interface IPokemonListViewModel {

  val uiAction: Channel<PokemonList.Action>
}