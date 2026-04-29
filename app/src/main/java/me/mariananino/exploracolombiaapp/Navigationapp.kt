package me.mariananino.exploracolombiaapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import me.mariananino.exploracolombiaapp.ui.elements.AddPlaceScreen
import me.mariananino.exploracolombiaapp.ui.elements.HomeScreen
import me.mariananino.exploracolombiaapp.ui.elements.LoginScreen
import me.mariananino.exploracolombiaapp.ui.elements.RegisterScreen

@Composable
fun NavigationApp() {

    val myNavController = rememberNavController()
    val auth = Firebase.auth
    val currentUser = auth.currentUser

    val myStartDestination = if (currentUser != null) {
        "home"
    } else {
        "login"
    }

    NavHost(
        navController = myNavController,
        startDestination = myStartDestination,
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

        composable(route = "home") {
            HomeScreen(
                onClickAddPlace = {
                    myNavController.navigate(route = "add_place")
                }
            )
        }

        composable(route = "add_place") {
            AddPlaceScreen(
                onBackClick = {
                    myNavController.navigate(route = "home") {
                        popUpTo("home") {
                            inclusive = false
                        }
                    }
                }
            )
        }
    }
}

