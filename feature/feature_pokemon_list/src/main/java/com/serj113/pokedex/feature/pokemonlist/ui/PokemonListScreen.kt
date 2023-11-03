package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.getPokemonId
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList
import kotlinx.coroutines.channels.Channel

@Composable
internal fun PokemonListScreen(viewState: PokemonList.ViewState, viewModel: IPokemonListViewModel) {
  ConstraintLayout {
    val (list, loading) = createRefs()

    val scrollState = rememberLazyGridState()
    LazyVerticalGrid(
      modifier = Modifier
        .constrainAs(list) {
          start.linkTo(parent.start)
          top.linkTo(parent.top)
          end.linkTo(parent.end)
          bottom.linkTo(parent.bottom)
        },
      columns = GridCells.Fixed(2),
      state = scrollState,
    ) {
      items(viewState.pokemonList) { pokemon ->
        val color = viewState.pokemonColor[pokemon.getPokemonId()] ?: ComposeColor.white
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
        if (!scrollState.canScrollForward) {
          viewModel.uiAction.trySend(PokemonList.Action.FetchNextPage)
        }
      },
    )

    if (viewState.isLoading) {
      Column(
        modifier = Modifier
          .background(
            color = ComposeColor.black.copy(alpha = 0.6f),
          )
          .constrainAs(loading) {
            start.linkTo(parent.start)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
          }
          .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        CircularProgressIndicator(
          modifier = Modifier
            .width(64.dp)
            .height(64.dp),
          color = MaterialTheme.colorScheme.surfaceVariant,
          strokeWidth = 4.dp,
        )
      }
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