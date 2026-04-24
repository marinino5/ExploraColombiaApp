package me.mariananino.exploracolombiaapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationApp() {

    val myNavController = rememberNavController()

    NavHost(
        navController = myNavController,
        startDestination = "login",
        modifier = Modifier.fillMaxSize()
    ) {

        composable("login") {
            LoginScreen(
                onLoginSuccess = {
                    myNavController.navigate("home") {
                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },
                onNavigateToRegister = {
                    myNavController.navigate("register")
                }
            )
        }

        composable("register") {
            RegisterScreen(
                onRegisterSuccess = {
                    myNavController.navigate("login")
                },
                onNavigateToLogin = {
                    myNavController.navigate("login")
                },
                onBackClick = {
                    myNavController.popBackStack()
                }
            )
        }

        composable("home") {
            HomeScreen()
        }
    }
}


