package com.example.composex.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun PrimaryButton(
    modifier: Modifier,
    padding: PaddingValues,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = { onClick() }
    ) {
        Text(
            modifier = Modifier
                .semantics { contentDescription = "" }
                .padding(padding),
            text = text)
    }
}

@Preview()
@Composable
fun PrimaryButtonPreview() {
    var count by remember { mutableStateOf(0) }

    Scaffold { p ->
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = count.toString(),
                fontSize = MaterialTheme.typography.displayLarge.fontSize
            )
        }
        Box(
            modifier = Modifier
                .padding(p)
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {

            Column {
                PrimaryButton(
                    modifier = Modifier
                        .padding(5.dp,10.dp)
                        .fillMaxWidth(),
                    padding = PaddingValues(0.dp, 10.dp),
                    "Count Up"
                ) {
                    count++
                }

                PrimaryButton(
                    modifier = Modifier
                        .padding(5.dp,10.dp)
                        .fillMaxWidth(),
                    padding = PaddingValues(0.dp, 10.dp),
                    "Count Down"
                ) {
                    count--
                }
            }


        }

    }
}