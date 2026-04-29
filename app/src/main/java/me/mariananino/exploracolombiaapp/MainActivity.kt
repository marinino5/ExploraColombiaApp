package me.mariananino.exploracolombiaapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import me.mariananino.exploracolombiaapp.ui.theme.ExploraColombiaAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExploraColombiaAPPTheme() {
                NavigationApp()
            }
        }
    }
}


