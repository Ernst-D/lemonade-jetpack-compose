package com.example.lemonadedemo.shared

import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CommonScreen(image: String, textContent: String){

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Header() {
    val customColor = Color.Yellow

    // TopAppBar with custom background color
    TopAppBar(
        modifier = Modifier
            .background(customColor),
        title = {
            Text(text = "Your App Title")
        },
        navigationIcon = {
            IconButton(onClick = { /* Handle navigation icon click */ }) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu")
            }
        },
        actions = {
            // You can add any actions here
        }
    )
}

@Preview
@Composable
private fun HeaderPreview(){
    Header()
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CommonScreenPreview(){

}