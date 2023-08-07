package com.serj113.pokedex.common.navigation

sealed class Route(val path: String) {
  object List: Route(Path.LIST)
  object Detail: Route(Path.DETAIL)
}