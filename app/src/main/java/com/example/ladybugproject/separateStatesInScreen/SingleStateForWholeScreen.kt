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
fun SingleStateForWholeScreen(modifier: Modifier = Modifier) {
    val uiState = remember { mutableStateOf(SingleState("ram","sham")) }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextContent1(uiState = uiState.value)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                if( uiState.value.t1 == "ram" ){
                    uiState.value = uiState.value.copy(t1="rohan")
                }else{
                    uiState.value = uiState.value.copy("ram")
                }
            }) {
                Text("Update t1")
            }
            Button(onClick = {
                if( uiState.value.t2 == "sham" ){
                    uiState.value = uiState.value.copy(t2="sohan")
                }else{
                    uiState.value = uiState.value.copy(t2="sham")
                }
            }) {
                Text("Update t2")
            }
        }
        TextContent2(uiState = uiState.value)
    }
}

@Composable
fun TextContent1(modifier: Modifier = Modifier,uiState: SingleState) {
//    Log.d("LOG","t1 updated with $text")
    Log.d("LOG","text content 1 uiState updated with $uiState")
    Text(text = uiState.t1)
}

@Composable
fun TextContent2(modifier: Modifier = Modifier,uiState: SingleState) {
//    Log.d("LOG","t2 updated with $text")
    Log.d("LOG","text content 2 uiState updated with $uiState")
    Text(text = uiState.t2)
}


data class SingleState(
    val t1: String,
    val t2: String
)