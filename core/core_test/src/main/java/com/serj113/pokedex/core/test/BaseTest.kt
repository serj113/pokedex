package com.serj113.pokedex.core.test

import io.mockk.junit5.MockKExtension
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
open class BaseTest {
  @BeforeEach
  open fun setup() {
    Dispatchers.setMain(StandardTestDispatcher())
  }

  @AfterEach
  open fun tearDown() {
    Dispatchers.resetMain()
  }
}