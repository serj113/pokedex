package com.serj113.pokedex.feature.pokemonlist.data

import androidx.compose.ui.graphics.Color
import com.serj113.pokedex.core.model.DataItem

object PokemonList {

  data class ViewState(
    val count: Int = 0,
    val pokemonList: List<DataItem> = emptyList(),
    val pokemonColor: HashMap<Int, Color> = hashMapOf(),
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