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

public val Icons.OutlinedStar: ImageVector
  get() {
    if (_star != null) {
      return _star!!
    }
    _star = ImageVector.Builder(
      name = "star_rate",
      defaultWidth = 24.0.dp,
      defaultHeight = 24.0.dp,
      viewportWidth = 24.0f,
      viewportHeight = 24.0f
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
        moveTo(14.875f, 29.125f)
        lineTo(20f, 25.208f)
        lineToRelative(5.125f, 3.917f)
        lineToRelative(-2.042f, -6.458f)
        lineToRelative(4.75f, -3.167f)
        horizontalLineToRelative(-5.75f)
        lineTo(20f, 13.042f)
        lineTo(17.917f, 19.5f)
        horizontalLineToRelative(-5.75f)
        lineToRelative(4.75f, 3.167f)
        close()
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
        moveToRelative(10f, -15.125f)
        close()
      }
    }.build()
    return _star!!
  }

private var _star: ImageVector? = null