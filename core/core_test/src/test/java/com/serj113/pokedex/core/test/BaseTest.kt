package com.serj113.pokedex.core.test

class BaseTest {
  @get:Rule
  val instantExecutor = InstantTaskExecutorRule()

  @Before
  fun setup() {
    Dispatchers.setMain(TestCoroutineDispatcher())
  }

  @After
  fun tearDown() {
    Dispatchers.resetMain()
  }
}