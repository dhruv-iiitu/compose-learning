package com.example.ladybugproject.nestedgraphs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ladybugproject.R
import com.example.ladybugproject.ui.theme.LadyBugProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_LadyBugProject)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LadyBugProjectTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigationGraph(
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
