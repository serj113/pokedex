package com.serj113.pokedex.core.domain.usecase

import com.serj113.pokedex.core.model.ApiResult

interface GetColorWithSpeciesIdUseCase {
  suspend operator fun invoke(id: Int): ApiResult<String>
}