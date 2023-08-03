package com.serj113.pokedex.core.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataItem(
  @field:Json(name = "name")
  var name: String = "",
  @field:Json(name = "url")
  var url: String = "",
)