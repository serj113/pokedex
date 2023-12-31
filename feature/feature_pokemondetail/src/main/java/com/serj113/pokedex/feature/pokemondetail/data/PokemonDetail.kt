package com.serj113.pokedex.feature.pokemondetail.data

import androidx.compose.ui.graphics.Color
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.EvolutionChainResponse
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonMoveResponse

object PokemonDetail {
  data class ViewState(
    val pokemonId: Int = 0,
    val pokemonDataItem: DataItem = DataItem(),
    val pokemonColor: Color = ComposeColor.white,
    val pokemonDetail: PokemonDetailResponse = PokemonDetailResponse(),
    val abilities: List<PokemonAbilityResponse> = listOf(),
    val movesViewState: MovesViewState = MovesViewState.Loading,
    val evolutionChain: EvolutionChainResponse = EvolutionChainResponse(),
  )

  sealed interface MovesViewState {
    data class Loaded(val moves: List<PokemonMoveResponse>) : MovesViewState
    object Loading : MovesViewState
  }

  sealed class Action {
    object InnitPage : Action()
    object OnBackPressed : Action()
    object OnFavoritePressed : Action()
  }

  sealed class Event {
    object GoBack : Event()
  }
}