package com.serj113.pokedex.core.data.repository

import arrow.core.Either
import com.serj113.pokedex.core.data.service.PokemonService
import com.serj113.pokedex.core.domain.repository.PokemonRepository
import com.serj113.pokedex.core.model.PokemonAbilityResponse
import com.serj113.pokedex.core.model.PokemonColorDetailResponse
import com.serj113.pokedex.core.model.PokemonColorListResponse
import com.serj113.pokedex.core.model.PokemonDetailResponse
import com.serj113.pokedex.core.model.PokemonListResponse
import com.serj113.pokedex.core.model.PokemonMoveResponse
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
  fun testFetchPokemonList() = runTest {
    val response = PokemonListResponse()
    coEvery { service.getPokemonList(any(), any()) } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonList(
      offset = 0,
      limit = 5,
    )

    (serviceResponse as? Either.Left<PokemonListResponse>)?.value?.count shouldBe response.count
  }

  @Test
  fun testFetchPokemonDetail() = runTest {
    val response = PokemonDetailResponse()
    coEvery { service.getPokemonDetail(any()) } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonDetail(1)

    (serviceResponse as? Either.Left<PokemonDetailResponse>)?.value?.id shouldBe response.id
  }

  @Test
  fun testfetchPokemonColorList() = runTest {
    val response = PokemonColorListResponse()
    coEvery { service.getPokemonColorList() } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonColorList()

    (serviceResponse as? Either.Left<PokemonColorListResponse>)?.value?.count shouldBe response.count
  }

  @Test
  fun testFetchPokemonColorDetail() = runTest {
    val response = PokemonColorDetailResponse()
    coEvery { service.getPokemonColorDetail(any()) } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonColorDetail(1)

    (serviceResponse as? Either.Left<PokemonColorDetailResponse>)?.value?.id shouldBe response.id
  }

  @Test
  fun testFetchPokemonSpecies() = runTest {
    val response = PokemonSpeciesResponse()
    coEvery { service.getPokemonSpecies(any()) } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonSpecies(1)

    (serviceResponse as? Either.Left<PokemonSpeciesResponse>)?.value?.id shouldBe response.id
  }

  @Test
  fun testFetchPokemonAbility() = runTest {
    val response = PokemonAbilityResponse()
    coEvery { service.getPokemonAbility(any()) } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonAbility(1)

    (serviceResponse as? Either.Left<PokemonAbilityResponse>)?.value?.id shouldBe response.id
  }

  @Test
  fun testFetchPokemonMove() = runTest {
    val response = PokemonMoveResponse()
    coEvery { service.getPokemonMove(any()) } returns Response.success(response)

    val serviceResponse = repository.fetchPokemonMove(1)

    (serviceResponse as? Either.Left<PokemonMoveResponse>)?.value?.id shouldBe response.id
  }
}