package com.serj113.pokedex.core.domain.usecase

import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.domain.usecase.impl.GetSpeciesUseCaseImpl
import com.serj113.pokedex.core.model.ApiResult
import com.serj113.pokedex.core.model.PokemonSpeciesResponse
import com.serj113.pokedex.core.test.BaseTest
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class GetSpeciesUseCaseTest : BaseTest() {

  @MockK
  private lateinit var repository: PokemonRepository

  private lateinit var useCase: GetSpeciesUseCase

  @BeforeEach
  override fun setup() {
    useCase = GetSpeciesUseCaseImpl(
      repository = repository,
    )
  }

  @Test
  fun testInvoke() = runTest {
    val response = PokemonSpeciesResponse()
    coEvery { repository.fetchPokemonSpecies(any()) } returns ApiResult.Success(
      PokemonSpeciesResponse()
    )

    val useCaseResult = useCase(1)

    (useCaseResult as? ApiResult.Success)?.value?.id shouldBe response.id
  }
}