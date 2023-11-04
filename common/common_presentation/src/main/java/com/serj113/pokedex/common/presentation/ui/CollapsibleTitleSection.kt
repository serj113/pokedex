package com.serj113.pokedex.common.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp

@Composable
fun CollapsibleTitleSection(
  modifier: Modifier = Modifier,
  isExpanded: Boolean = false,
  title: String
) {

  val icon = if (isExpanded) {
    Icons.Rounded.KeyboardArrowUp
  } else Icons.Rounded.KeyboardArrowDown

  Row(
    modifier = modifier.padding(8.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Image(
      modifier = Modifier.size(32.dp),
      imageVector = icon,
      colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimaryContainer),
      contentDescription = stringResource(id = R.string.expand_or_collapse)
    )
    Text(text = title, style = MaterialTheme.typography.headlineMedium)
  }
}