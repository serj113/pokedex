package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.getPokemonId
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList
import com.serj113.pokedex.feature.pokemonlist.util.getSpriteImage
import kotlinx.coroutines.channels.Channel

@Composable
fun PokemonItem(pokemon: DataItem, viewModel: IPokemonListViewModel) {
  Card(
    shape = RoundedCornerShape(8.dp),
    modifier = Modifier
      .clickable {
        viewModel.uiAction.trySend(PokemonList.Action.OnClickItem(pokemon.getPokemonId()))
      }
      .padding(4.dp),
  ) {
    Row(
      horizontalArrangement = Arrangement.SpaceEvenly,
      modifier = Modifier.padding(8.dp),
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
      ) {
        Text(
          text = pokemon.name,
          style = MaterialTheme.typography.bodyLarge
        )
      }
      AsyncImage(
        model = pokemon.getSpriteImage(),
        contentDescription = null,
        modifier = Modifier
          .fillMaxWidth()
          .weight(1f),
      )
    }
  }
}

@Preview
@Composable
fun PreviewPokemonItem() {
  PokemonItem(
    DataItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
    object : IPokemonListViewModel {
      override val uiAction: Channel<PokemonList.Action>
        get() = Channel(Channel.BUFFERED)
    }
  )
}