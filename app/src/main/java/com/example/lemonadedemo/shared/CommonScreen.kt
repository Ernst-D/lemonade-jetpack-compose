package com.example.lemonadedemo.shared

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemonadedemo.R
import com.example.lemonadedemo.ui.theme.LemonadeDemoTheme
import com.example.lemonadedemo.ui.theme.Yellow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CommonScreen(image: String, textContent: String) {
    Scaffold(
        topBar = {
        Header()
    }) {
        Column {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Header(modifier: Modifier = Modifier) {
    // TopAppBar with custom background color
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Yellow),
        title = {
            Text(
                modifier = modifier.fillMaxWidth(),
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
    LemonadeDemoTheme {
        CommonScreen(image = "test string", textContent = "test content")
    }
}