package com.example.ladybugproject.nestedgraphs.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun HomeScreen(modifier: Modifier = Modifier,onClick:()->Unit) {
    Column(
        modifier = modifier.background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Home Screen", color = Color.White)
        Button(onClick) {
            Text("go to profile")
        }

    }
}