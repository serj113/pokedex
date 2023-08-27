package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RadialGradientShader
import androidx.compose.ui.graphics.Shader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.tooling.preview.Preview
import com.serj113.pokedex.common.presentation.ComposeColor
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail
import kotlinx.coroutines.channels.Channel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PokemonDetailScreen(
  viewState: PokemonDetail.ViewState,
  viewModel: IPokemonDetailViewModel,
) {
  MaterialTheme {
    val largeRadialGradient = object : ShaderBrush() {
      override fun createShader(size: Size): Shader {
        val biggerDimension = maxOf(size.height, size.width)
        return RadialGradientShader(
          colors = listOf(viewState.pokemonColor, ComposeColor.white),
          center = Offset(size.width / 2f, size.height / 5f),
          radius = biggerDimension * 0.75f,
          colorStops = listOf(0f, 0.95f)
        )
      }
    }
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(
          largeRadialGradient,
        ),
    ) {
      Scaffold(
        topBar = {
          PokemonDetailAppBar(viewModel)
        },
        containerColor = Color.Transparent,
      ) { innerPadding ->
        LazyColumn(
          modifier = Modifier
            .padding(innerPadding),
        ) {
          item {
            PokemonDetailHeader(viewState = viewState)
          }
          item {
            PokemonDetailContent(viewState = viewState)
          }
        }
      }
    }
  }
}

@Preview
@Composable
internal fun PreviewPokemonDetailScreen() {
  PokemonDetailScreen(
    viewState = PokemonDetail.ViewState(
      pokemonColor = ComposeColor.red,
    ),
    viewModel = object : IPokemonDetailViewModel {
      override val uiAction: Channel<PokemonDetail.Action>
        get() = Channel()
    }
  )
}