package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.getPokemonId
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList
import kotlinx.coroutines.channels.Channel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PokemonListScreen(viewState: PokemonList.ViewState, viewModel: IPokemonListViewModel) {
  MaterialTheme {
    Scaffold { _ ->
      val scrollState = rememberLazyGridState()
      LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        state = scrollState,
      ) {
        items(viewState.pokemonList) { pokemon ->
          val color: Int = viewState.pokemonColor[pokemon.getPokemonId()] ?: android.graphics.Color.WHITE
          PokemonItem(
            pokemon = pokemon,
            color = color,
            viewModel = viewModel,
          )
        }
      }

      LaunchedEffect(
        key1 = !scrollState.canScrollForward,
        block = {
          viewModel.uiAction.trySend(PokemonList.Action.FetchNextPage)
        },
      )
    }
  }
}

@Preview
@Composable
internal fun PreviewPokemonListScreen() {
  PokemonListScreen(
    PokemonList.ViewState(
      pokemonList = listOf(
        DataItem("Pikachu", "Link"),
        DataItem("Bulbasaur", "Link"),
        DataItem("Charmender", "Link"),
        DataItem("Squirturtle", "Link"),
      ),
    ),
    object : IPokemonListViewModel {
      override val uiAction: Channel<PokemonList.Action>
        get() = Channel(Channel.BUFFERED)
    }
  )
}