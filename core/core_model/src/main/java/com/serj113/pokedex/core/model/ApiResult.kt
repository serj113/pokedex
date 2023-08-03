package com.serj113.pokedex.core.model

sealed class ApiResult<out T> {
  data class Success<out T>(val value: T) : ApiResult<T>()
  data class Error(val e: Exception? = null) : ApiResult<Nothing>()
}