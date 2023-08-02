package com.serj113.pokedex.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.findNavController
import com.serj113.pokedex.R
import com.serj113.pokedex.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

//class MainActivity : ComponentActivity() {
//  override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContent {
//      PokedexTheme {
//        // A surface container using the 'background' color from the theme
//        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//          Greeting("Android")
//        }
//      }
//    }
//  }
//}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  override fun onSupportNavigateUp() =
    findNavController(com.serj113.pokedex.common.navigation.R.id.pokemon_list).navigateUp()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
  Text(
    text = "Hello $name!",
    modifier = modifier
  )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  PokedexTheme {
    Greeting("Android")
  }
}