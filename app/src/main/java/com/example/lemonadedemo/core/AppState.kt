package com.example.lemonadedemo.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

private sealed class Screen {
    object LemonTree: Screen()
    object SqueezeLemon: Screen()
    object LemonadeToDrink: Screen()
    object EmptyGlass: Screen()
}

@Composable
fun AppState(){
    var currentScreen by remember {
        mutableStateOf(Screen.LemonTree)
    }


}