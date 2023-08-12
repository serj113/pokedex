package com.serj113.pokedex.feature.pokemondetail.ui

import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail
import kotlinx.coroutines.channels.Channel

interface IPokemonDetailViewModel {

  val uiAction: Channel<PokemonDetail.Action>
}