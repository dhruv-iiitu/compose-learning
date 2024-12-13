package com.example.ladybugproject.separateStatesInScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.ladybugproject.separateStatesInScreen.ui.theme.LadyBugProjectTheme

class SeparateStateInSingleScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LadyBugProjectTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val padding = Modifier.padding(innerPadding)
                    SingleStateForWholeScreen(Modifier.fillMaxSize().background(Color.White))
                    SingleStateForWholeScreen2(Modifier.fillMaxSize().background(Color.White))
//                    MultipleStateForWholeScreen(Modifier.fillMaxSize().background(Color.Cyan))
                }
            }
        }
    }
}