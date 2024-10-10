package com.example.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ScrollableColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 1")
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 2")
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 3")
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 4")
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 5")
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 6")
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 7")
        Text(modifier = Modifier.padding(vertical = 50.dp), text = "Hello 8")
    }
}