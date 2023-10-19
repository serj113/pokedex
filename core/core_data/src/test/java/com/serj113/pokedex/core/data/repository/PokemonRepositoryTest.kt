package com.serj113.pokedex.core.data.repository

import com.serj113.pokedex.core.data.service.PokemonService
import com.serj113.pokedex.core.domain.repository.PokemonRepository
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
import retrofit2.Response

@ExtendWith(MockKExtension::class)
class PokemonRepositoryTest : BaseTest() {

  @MockK
  private lateinit var service: PokemonService

  private lateinit var repository: PokemonRepository

  @BeforeEach
  override fun setup() {
    super.setup()
    repository = PokemonRepositoryImpl(
      service = service
    )
  }

  @Test
  fun testFetchPokemonSpecies() = runTest {
    val response = PokemonSpeciesResponse()
    coEvery { service.getPokemonSpecies(any()) } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonSpecies(1)

    (serviceResponse as? ApiResult.Success)?.value?.id shouldBe response.id
  }
}