package com.ps.composemultiplatformplayground

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun AppScreen() {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }

    var showForFiveSeconds by remember { mutableStateOf(false) }
    var showText by remember { mutableStateOf(false) }

    LaunchedEffect(showForFiveSeconds) {
        if (showForFiveSeconds) {
            showText = true
            delay(5000L)
            showForFiveSeconds = false
            showText = false
            name = ""
            surname = ""
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        if (showText) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Hi $name $surname!"
                )
            }
        } else {

            OutlinedTextField(modifier = Modifier.fillMaxWidth(0.7f),
                value = name,
                placeholder = { Text(text = "Enter name...") },
                onValueChange = { name = it })

            Spacer(modifier = Modifier.height(4.dp))

            OutlinedTextField(modifier = Modifier.fillMaxWidth(0.7f),
                value = surname,
                placeholder = { Text(text = "Enter surname...") },
                onValueChange = { surname = it })

            Spacer(modifier = Modifier.height(12.dp))

            Button(modifier = Modifier.fillMaxWidth(0.5f), onClick = {
                if (name.isNotBlank() && surname.isNotBlank()) {
                    showForFiveSeconds = true
                }
            }) {
                Text(text = "Submit")
            }
        }
    }

}