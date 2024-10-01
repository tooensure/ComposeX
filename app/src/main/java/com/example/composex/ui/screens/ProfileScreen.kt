package com.example.composex.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.composex.R
import com.example.composex.ui.components.ProfileCard

val url = "https://scontent-ord5-2.xx.fbcdn.net/v/t39.30808-6/409613815_257738760646835_3113292385093050498_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=6ee11a&_nc_ohc=2yN4GrIAIywQ7kNvgGkrXmW&_nc_ht=scontent-ord5-2.xx&_nc_gid=AIlEdj0nhxCCS-teMz02-6l&oh=00_AYCnni6DysMMGUdpsdon5j72pWSKgpOqHXdgNZEvxUvzXQ&oe=6701CDDD"

@Preview(showBackground = true)
@Composable
fun ProfileScreen() {
    // State is hoisted here in the parent composable (ProfileScreen)
    var name by remember { mutableStateOf("Shawn Bellazan") }
    var title by remember { mutableStateOf("Software Developer") }

    // Pass the state down and handle the event of data change
    ProfileLayout(name, title) { newName, newTitle ->
        name = newName // Update the state when changes occur
        title = newTitle
    }
}

@Composable
fun ProfileLayout(
    name: String,
    title: String,
    onUpdateProfile: (String, String) -> Unit
) {
    // UI Components (e.g., TextFields for editing name and title)
    Column {
        // Display or Edit Name
        Text(text = name)

        // Display or Edit Title
        Text(text = title)

        // Simulate an action that updates name and title, e.g., button click
        Button(onClick = {
            onUpdateProfile("Updated Name", "Updated Title") // Callback to pass data up
        }) {
            Text(text = "Update Profile")
        }
    }
}