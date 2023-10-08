package com.serj113.pokedex.feature.pokemonlist.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.core.model.DataItem
import com.serj113.pokedex.core.model.utils.getPokemonId
import com.serj113.pokedex.core.model.utils.getSpriteImage
import com.serj113.pokedex.feature.pokemonlist.data.PokemonList
import kotlinx.coroutines.channels.Channel

@Composable
fun PokemonItem(pokemon: DataItem, color: Color, viewModel: IPokemonListViewModel) {
  if (pokemon.getPokemonId() % 2 == 0) {
    PokemonItemLeft(pokemon, color, viewModel)
  } else PokemonItemRight(pokemon, color, viewModel)
}

@Composable
fun PokemonItemLeft(pokemon: DataItem, color: Color, viewModel: IPokemonListViewModel) {
  val largeRadialGradient = object : ShaderBrush() {
    override fun createShader(size: Size): Shader {
      val biggerDimension = maxOf(size.height, size.width)
      return RadialGradientShader(
        colors = listOf(color, ComposeColor.white),
        center = Offset(size.width * 0.25f, size.height * 0.5f),
        radius = biggerDimension * 0.9f,
        colorStops = listOf(0f, 0.75f)
      )
    }
  }
  Card(
    shape = RoundedCornerShape(8.dp),
    colors = CardDefaults.cardColors(
      containerColor = Color.Transparent,
    ),
    modifier = Modifier
      .clickable {
        viewModel.uiAction.trySend(PokemonList.Action.OnClickItem(pokemon.getPokemonId()))
      }
      .padding(4.dp),
  ) {
    Box(
      modifier = Modifier
        .background(largeRadialGradient),
    ) {
      Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(8.dp),
      ) {
        AsyncImage(
          model = pokemon.getSpriteImage(),
          contentDescription = null,
          modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        )
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
      }
    }
  }
}

@Composable
fun PokemonItemRight(pokemon: DataItem, color: Color, viewModel: IPokemonListViewModel) {
  val largeRadialGradient = object : ShaderBrush() {
    override fun createShader(size: Size): Shader {
      val biggerDimension = maxOf(size.height, size.width)
      return RadialGradientShader(
        colors = listOf(color, ComposeColor.white),
        center = Offset(size.width * 0.75f, size.height * 0.5f),
        radius = biggerDimension * 0.9f,
        colorStops = listOf(0f, 0.75f)
      )
    }
  }
  Card(
    shape = RoundedCornerShape(8.dp),
    modifier = Modifier
      .clickable {
        viewModel.uiAction.trySend(PokemonList.Action.OnClickItem(pokemon.getPokemonId()))
      }
      .padding(4.dp),
  ) {
    Box(
      modifier = Modifier
        .background(largeRadialGradient),
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
}

@Preview
@Composable
fun PreviewPokemonItem() {
  PokemonItem(
    DataItem("bulbasaur", "https://pokeapi.co/api/v2/pokemon/1/"),
    ComposeColor.green,
    object : IPokemonListViewModel {
      override val uiAction: Channel<PokemonList.Action>
        get() = Channel(Channel.BUFFERED)
    }
  )
}