package com.serj113.pokedex.feature.pokemondetail.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.serj113.pokedex.feature.pokemondetail.data.PokemonDetail

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailAppBar(viewModel: IPokemonDetailViewModel) {
  TopAppBar(
    title = { },
    colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color.Transparent),
    navigationIcon = {
      IconButton(
        onClick = {
          viewModel.uiAction.trySend(PokemonDetail.Action.OnBackPressed)
        },
      ) {
        Icon(
          imageVector = Icons.Filled.ArrowBack, contentDescription = null
        )
      }
    },
    actions = {
      IconButton(
        onClick = {
          viewModel.uiAction.trySend(PokemonDetail.Action.OnFavoritePressed)
        },
      ) {
        Icon(
          imageVector = Icons.Filled.Star, contentDescription = null
        )
      }
    },
  )
}