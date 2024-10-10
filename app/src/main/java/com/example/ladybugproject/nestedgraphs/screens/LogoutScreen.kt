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
fun LogoutScreen(modifier: Modifier = Modifier,onClick:()->Unit) {
    Column(
        modifier = modifier.background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Logout Screen", color = Color.Black)
        Button(onClick) {
            Text("Go to login")
        }

    }
}