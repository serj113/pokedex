package com.serj113.pokedex.common.presentation.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun CollapsibleSection(
  modifier: Modifier = Modifier,
  titleContent: @Composable RowScope.() -> Unit,
  content: @Composable () -> Unit
) {
  var isExpanded by rememberSaveable { mutableStateOf(false) }
  Column(
    modifier = modifier
      .clickable { isExpanded = !isExpanded }
      .fillMaxWidth()
  ) {
    CollapsibleTitleSection(isExpanded = isExpanded, content = titleContent)

    AnimatedVisibility(
      modifier = Modifier
        .fillMaxWidth(),
      visible = isExpanded
    ) {
      content()
    }
  }
}