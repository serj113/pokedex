package com.serj113.pokedex.common.presentation.icons

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

public val Icons.FilledStar: ImageVector
  get() {
    if (_star != null) {
      return _star!!
    }
    _star = ImageVector.Builder(
      name = "star_rate",
      defaultWidth = 40.0.dp,
      defaultHeight = 40.0.dp,
      viewportWidth = 40.0f,
      viewportHeight = 40.0f
    ).apply {
      path(
        fill = SolidColor(Color.Black),
        fillAlpha = 1f,
        stroke = null,
        strokeAlpha = 1f,
        strokeLineWidth = 1.0f,
        strokeLineCap = StrokeCap.Butt,
        strokeLineJoin = StrokeJoin.Miter,
        strokeLineMiter = 1f,
        pathFillType = PathFillType.NonZero
      ) {
        moveTo(10f, 36.208f)
        lineToRelative(3.792f, -12.25f)
        lineToRelative(-9.959f, -7.166f)
        horizontalLineToRelative(12.292f)
        lineTo(20f, 3.875f)
        lineToRelative(3.875f, 12.917f)
        horizontalLineToRelative(12.292f)
        lineToRelative(-9.959f, 7.166f)
        lineTo(30f, 36.208f)
        lineToRelative(-10f, -7.583f)
        close()
      }
    }.build()
    return _star!!
  }

private var _star: ImageVector? = null