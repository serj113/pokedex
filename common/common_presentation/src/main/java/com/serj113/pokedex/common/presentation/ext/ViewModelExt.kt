package com.serj113.pokedex.common.presentation.ext

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

fun ViewModel.trySend() {
  viewModelScope.launch {

  }
}