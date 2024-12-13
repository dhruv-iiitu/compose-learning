package com.example.ladybugproject.separateStatesInScreen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun MultipleStateForWholeScreen(modifier: Modifier = Modifier) {
    val t3UiState = remember { mutableStateOf(TextUiState("ram")) }
    val t4UiState = remember { mutableStateOf(TextUiState("sham")) }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextContent3(modifier = Modifier, uiState = t3UiState.value)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                if (t3UiState.value.t == "ram") {
                    t3UiState.value = t3UiState.value.copy(t = "rohan")
                } else {
                    t3UiState.value = t3UiState.value.copy(t = "ram")
                }
            }) {
                Text("Update t3")
            }
            Button(onClick = {
                if (t4UiState.value.t == "sham") {
                    t4UiState.value = t4UiState.value.copy(t = "sohan")
                } else {
                    t4UiState.value = t4UiState.value.copy(t = "sham")
                }
            }) {
                Text("Update t4")
            }
        }
        TextContent4(uiState = t4UiState.value)

    }
}

data class TextUiState(
    val t: String
)

@Composable
fun TextContent3(modifier: Modifier = Modifier, uiState: TextUiState) {
    Log.d("LOG", "text content 3 uiState updated with $uiState")
    Text(text = uiState.t)
}

@Composable
fun TextContent4(modifier: Modifier = Modifier, uiState: TextUiState) {
    Log.d("LOG", "text content 4 uiState updated with $uiState")
    Text(text = uiState.t)
}