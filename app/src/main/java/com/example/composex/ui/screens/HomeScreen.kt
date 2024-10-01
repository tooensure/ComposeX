package com.example.composex.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composex.R
import com.example.composex.ui.screens.InputTextField

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
    // State for name and title is managed separately
    var name by remember { mutableStateOf("") }
    var title by remember { mutableStateOf("") }

    HomeScreenLayout(
        name = name,
        title = title,
        onNameChanged = { newName -> name = newName},
        onTitleChanged = { newTitle -> title = newTitle}
    )
}

@Composable
fun HomeScreenLayout(
    name: String,
    title: String,
    onNameChanged: (String) -> Unit,
    onTitleChanged: (String) -> Unit
) {
    Scaffold(
        content = { p ->
            Box(
                Modifier.fillMaxSize().padding(10.dp),
                contentAlignment = Alignment.Center) {
                // UI Components (e.g., TextFields for editing name and title)
                Column(Modifier.padding(p)) {
                    NameTextField(name) { onNameChanged(it) }
                    TitleTextField(title) { onTitleChanged(it) }
                }
            }
        }
    )
}

@Composable
fun InputTextField(
    label: String,
    placeholder: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    // UI Components (e.g., TextFields for editing name and title)
    // Display or Edit Name
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        label = { Text(label) },
        placeholder = { Text(placeholder) }
    )
}


@Composable
fun NameTextField(
    name: String,
    onValueChanged: (String) -> Unit
) {
    // Display or Edit Name
    InputTextField(
        label = "Name",
        placeholder = "Enter your name",
        value = name,
        onValueChange = { onValueChanged(it) }
    )
}

@Composable
fun TitleTextField(
    title: String,
    onValueChanged: (String) -> Unit
) {
    // Display or Edit Title
    InputTextField(
        label = "Title",
        placeholder = "Enter your title",
        value = title,
        onValueChange = { onValueChanged(it) }
    )
}