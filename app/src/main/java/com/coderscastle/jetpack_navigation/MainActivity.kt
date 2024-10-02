package com.coderscastle.jetpack_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.coderscastle.jetpack_navigation.ui.theme.JetpackNavigationTheme
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackNavigationTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController ,
                    startDestination = ScreenA
                ) {

                    composable<ScreenA> {

                        Column (
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){

                            Text(text="Screen A")
                            Button(onClick = {

                                navController.navigate(ScreenB(
                                    "Android",
                                    25
                                ))

                            }) {
                                Text(text="Go to Screen B")
                            }
                        }
                    }

                    composable<ScreenB> {

                        val args = it.toRoute<ScreenB>()
                        Column (
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){

                            Text(text="${args.name},you are ${args.age} years old")
                        }

                    }
                }
            }
        }
    }
}

@Serializable
object ScreenA

@Serializable
data class ScreenB (
    val name :String,
    val age :Int
)
