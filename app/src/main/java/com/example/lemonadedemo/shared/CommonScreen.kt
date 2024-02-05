package com.example.lemonadedemo.shared

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonadedemo.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CommonScreen(image: String, textContent: String) {
    Scaffold(topBar = {
        Header()
    }) {
        Column {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Header() {
    val customColor = Yellow

    // TopAppBar with custom background color
    TopAppBar(
        modifier = Modifier
            .background(customColor),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.header_text),
                fontWeight = FontWeight.Bold
            )
        },
        actions = {
            // You can add any actions here
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    Header()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CommonScreenPreview() {
    CommonScreen(image = "test string", textContent = "test content")
}