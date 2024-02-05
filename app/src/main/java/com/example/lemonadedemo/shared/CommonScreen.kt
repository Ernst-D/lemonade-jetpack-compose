package com.example.lemonadedemo.shared

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
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
            LemonadeBox(modifier, image, contentDesc)
            Text(text = screenText, modifier = Modifier.padding(vertical = 20.dp))
        }
    }
}

@Composable
private fun LemonadeBox(
    modifier: Modifier,
    image: Painter,
    contentDesc: String
) {
    val context = LocalContext.current

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                colorResource(id = R.color.lemonade_box_background),
                shape = RoundedCornerShape(16.dp)
            )
            .size(250.dp, 250.dp)
            .clickable {
                Toast
                    .makeText(context, "Button Clicked!", Toast.LENGTH_SHORT)
                    .show()
            }
    ) {
        Image(painter = image, contentDescription = contentDesc)
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeBoxPreview() {
    LemonadeBox(
        modifier = Modifier,
        image = painterResource(id = R.drawable.lemon_squeeze),
        contentDesc = stringResource(
            id = R.string.keep_tapping_text
        )
    )
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