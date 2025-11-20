package com.example.prak8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.prak8.ui.theme.Prak8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Prak8Theme {
                // Panggil SiswaApp sebagai root composable
                SiswaApp(
                    modifier = Modifier
                )
            }
        }
    }
}
