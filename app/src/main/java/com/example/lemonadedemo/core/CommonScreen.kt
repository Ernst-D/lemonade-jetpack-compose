package com.example.lemonadedemo.core

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadedemo.R
import com.example.lemonadedemo.ui.theme.LemonadeDemoTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CommonScreen(
    image: Painter,
    screenText: String,
    contentDesc: String,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            Header()
        }) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LemonadeBox(modifier)
            Text(text = screenText, modifier = Modifier.padding(vertical = 20.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Header(modifier: Modifier = Modifier) {
    // TopAppBar with custom background color
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = colorResource(id = R.color.header_background)),
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
        CommonScreen(
            image = painterResource(id = R.drawable.lemon_squeeze),
            screenText = stringResource(id = R.string.keep_tapping_text),
            contentDesc = stringResource(id = R.string.keep_tapping_content_desc)
        )
    }
}