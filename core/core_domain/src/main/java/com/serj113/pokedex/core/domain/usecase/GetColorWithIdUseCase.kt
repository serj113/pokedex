package com.serj113.pokedex.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult

interface GetColorWithIdUseCase {
  suspend operator fun invoke(id: Int): ApiResult<String>
}