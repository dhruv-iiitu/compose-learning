package com.example.ladybugproject.typeSafeNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

// Data Model
data class Message2(val text: String, val isSent: Boolean, val timestamp: String)

@Composable
fun WhatsAppChatScreen() {
    var messages by remember {
        mutableStateOf(
            listOf(
                Message2("Hey! How are you?", isSent = false, timestamp = "10:00 AM"),
                Message2("I'm good! What about you?", isSent = true, timestamp = "10:01 AM"),
                Message2("All well, just chilling!", isSent = false, timestamp = "10:02 AM"),
                Message2("Did you watch the game last night?", isSent = true, timestamp = "10:05 AM"),
                Message2("Yes! It was amazing!", isSent = false, timestamp = "10:06 AM"),
                Message2("I can't believe that final goal!", isSent = true, timestamp = "10:07 AM"),
                Message2("Same here! It was a nail-biter.", isSent = false, timestamp = "10:08 AM"),
                Message2("Let's catch up this weekend?", isSent = true, timestamp = "10:10 AM"),
                Message2("Sure! Let's plan for Saturday evening.", isSent = false, timestamp = "10:12 AM"),
                Message2("Great! See you then!", isSent = true, timestamp = "10:15 AM"),
                Message2("By the way, did you finish that report?", isSent = false, timestamp = "10:20 AM"),
                Message2("Almost! Just reviewing the last section.", isSent = true, timestamp = "10:22 AM"),
                Message2("Nice! Need any help?", isSent = false, timestamp = "10:23 AM"),
                Message2("I think I'm good, but I'll let you know!", isSent = true, timestamp = "10:24 AM"),
                Message2("Cool. Oh, have you tried that new café downtown?", isSent = false, timestamp = "10:26 AM"),
                Message2("Not yet! Is it good?", isSent = true, timestamp = "10:27 AM"),
                Message2("Yeah! Their coffee is amazing. We should go sometime.", isSent = false, timestamp = "10:28 AM"),
                Message2("Sounds great! Maybe after our weekend meet-up?", isSent = true, timestamp = "10:30 AM"),
                Message2("Perfect! I'll text you the location.", isSent = false, timestamp = "10:32 AM"),
                Message2("Awesome. Looking forward to it!", isSent = true, timestamp = "10:33 AM")
            )

        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.weight(1f), reverseLayout = true) {
            items(messages.reversed()) { message ->
                ChatBubble(message)
            }
        }

        var inputText by remember { mutableStateOf(TextFieldValue("")) }

        // Input Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            BasicTextField(
                value = inputText,
                onValueChange = { inputText = it },
                textStyle = TextStyle(fontSize = 16.sp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Send),
                keyboardActions = KeyboardActions(onSend = {
                    if (inputText.text.isNotBlank()) {
                        val time = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
                        messages = messages + Message2(inputText.text, isSent = true, timestamp = time)
                        inputText = TextFieldValue("")
                    }
                }),
                modifier = Modifier
                    .weight(1f)
                    .background(Color.LightGray, RoundedCornerShape(20.dp))
                    .padding(12.dp),
                decorationBox = { innerTextField ->
                    if (inputText.text.isEmpty()) {
                        Text(
                            text = "Type a message...",
                            fontSize = 16.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.padding(start = 4.dp)
                        )
                    }
                    innerTextField()
                }
            )

            IconButton(onClick = {
                if (inputText.text.isNotBlank()) {
                    val time = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(Date())
                    messages = messages + Message2(inputText.text, isSent = true, timestamp = time)
                    inputText = TextFieldValue("")
                }
            }) {
                Icon(Icons.Filled.Send, contentDescription = "Send", tint = Color.Blue)
            }
        }
    }
}

@Composable
fun ChatBubble(message: Message2) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = if (message.isSent) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .background(if (message.isSent) Color(0xFFDCF8C6) else Color.White, RoundedCornerShape(12.dp))
                .padding(12.dp)
                .widthIn(max = 250.dp)
        ) {
            Text(text = message.text, fontSize = 16.sp)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = message.timestamp, fontSize = 12.sp)
        }
    }
    Spacer(modifier = Modifier.height(8.dp))
}


// Chat Gpt
@Preview(showBackground = true)
@Composable
fun PreviewChatScreen2() {
    WhatsAppChatScreen()
}