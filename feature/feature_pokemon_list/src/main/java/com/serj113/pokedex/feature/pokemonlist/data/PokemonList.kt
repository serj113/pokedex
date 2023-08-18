package com.serj113.pokedex.feature.pokemonlist.data

import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.PokemonDetailResponse
import java.util.concurrent.ConcurrentHashMap

object PokemonList {

  data class ViewState(
    val count: Int = 0,
    val pokemonList: List<DataItem> = emptyList(),
    val pokemonColor: HashMap<Int, Int> = hashMapOf(),
    val page: Int = 1,
    val hasNext: Boolean = false,
  )

  sealed class Event {
    data class GoToDetail(val pokemonId: Int) : Event()
  }

  sealed class Action {
    data class OnClickItem(val pokemonId: Int) : Action()
    object FetchNextPage : Action()
  }
}