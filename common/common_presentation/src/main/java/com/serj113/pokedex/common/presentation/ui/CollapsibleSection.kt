package com.serj113.pokedex.common.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier

@Composable
fun CollapsibleSection(
  modifier: Modifier = Modifier,
  title: String,
  content: @Composable () -> Unit
) {
  var isExpanded by rememberSaveable { mutableStateOf(false) }
  Column(
    modifier = modifier
      .clickable { isExpanded = !isExpanded }
      .background(color = MaterialTheme.colorScheme.primaryContainer)
      .fillMaxWidth()
  ) {
    ExpandableSectionTitle(isExpanded = isExpanded, title = title)

    AnimatedVisibility(
      modifier = Modifier
        .background(MaterialTheme.colorScheme.secondaryContainer)
        .fillMaxWidth(),
      visible = isExpanded
    ) {
      content()
    }
  }
}