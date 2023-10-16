package com.serj113.pokedex.core.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test

class BaseTest {
  @get:Rule
  val instantExecutor = InstantTaskExecutorRule()

  @BeforeEach
  fun setup() {
    Dispatchers.setMain(StandardTestDispatcher())
  }

  @AfterEach
  fun tearDown() {
    Dispatchers.resetMain()
  }

  @Test
}