package com.example.ladybugproject.typeSafeNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.UUID


// DeepSeek
@Preview(showBackground = true)
@Composable
fun PreviewChatScreen() {
    ChatScreen()
}
@Composable
fun ChatScreen() {
    val messages = remember {
        mutableStateListOf(
            Message(id = "16", text = "I definitely will. Thanks for the tip!", isFromMe = true),
            Message(id = "15", text = "They added some great tools for Compose development. You should check it out!", isFromMe = false),
            Message(id = "14", text = "Not yet. What's new?", isFromMe = true),
            Message(id = "13", text = "By the way, have you tried the new Android Studio features?", isFromMe = false),
            Message(id = "12", text = "Sure, anytime!", isFromMe = true),
            Message(id = "11", text = "Not right now, but I'll let you know if I do. Thanks!", isFromMe = false),
            Message(id = "10", text = "Do you need any help with it?", isFromMe = true),
            Message(id = "9", text = "Yeah, it's making UI development so much easier.", isFromMe = false),
            Message(id = "8", text = "Wow, that's awesome! Jetpack Compose is really cool.", isFromMe = true),
            Message(id = "7", text = "I'm building a chat app using Jetpack Compose.", isFromMe = false),
            Message(id = "6", text = "That sounds interesting. What are you working on?", isFromMe = true),
            Message(id = "5", text = "I'm doing great! Just working on some projects.", isFromMe = false),
            Message(id = "4", text = "I'm good, thanks! How about you?", isFromMe = true),
            Message(id = "3", text = "How are you?", isFromMe = false),
            Message(id = "2", text = "Hi there!", isFromMe = true),
            Message(id = "1", text = "Hello!", isFromMe = false)
        )
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ChatList(
            messages = messages,
            modifier = Modifier.weight(1f) // This makes ChatList take all available space above ChatInput
        )
        ChatInput(
            modifier = Modifier.fillMaxWidth() // Ensures ChatInput stays at the bottom
        ) { newMessage ->
            messages.add(Message(id = UUID.randomUUID().toString(), text = newMessage, isFromMe = true))
        }
    }

}
@Composable
fun ChatInput(
    modifier: Modifier,
    onSendMessage: (String) -> Unit
) {
    var text by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp),
            placeholder = { Text("Type a message...") }
        )
        IconButton(
            onClick = {
                if (text.isNotBlank()) {
                    onSendMessage(text)
                    text = ""
                }
            }
        ) {
            Icon(imageVector = Icons.Default.Send, contentDescription = "Send")
        }
    }
}

@Composable
fun ChatList(modifier: Modifier,messages: List<Message>) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp),
        reverseLayout = true
    // Start from the bottom
    ) {
        items(messages) { message ->
            MessageItem(message = message)
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    val alignment = if (message.isFromMe) Alignment.TopEnd else Alignment.TopStart
    val backgroundColor = if (message.isFromMe) Color(0xFFDCF8C6) else Color(0xFFFFFFFF)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        contentAlignment = alignment
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(backgroundColor)
                .padding(8.dp)
        ) {
            Text(text = message.text)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = SimpleDateFormat("hh:mm a", Locale.getDefault()).format(message.timestamp),
                color = Color.Gray
            )
        }
    }
}

data class Message(
    val id: String,
    val text: String,
    val isFromMe: Boolean, // To differentiate between sender and receiver
    val timestamp: Long = System.currentTimeMillis()
)