package com.example.lemonadedemo.core

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.lemonadedemo.R

@Composable
fun AppState() {
    var currentScreen by remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    val screen = when (currentScreen) {
        0 -> {
            CommonScreen(
                image = painterResource(id = R.drawable.lemon_tree), screenText = stringResource(
                    id = R.string.lemon_tree_text
                ), contentDesc = stringResource(id = R.string.lemon_tree_content_desc)
            )
            currentScreen = 1
        }
        1 -> {
            CommonScreen(
                image = painterResource(id = R.drawable.lemon_squeeze), screenText = stringResource(
                    id = R.string.keep_tapping_text
                ), contentDesc = stringResource(id = R.string.keep_tapping_content_desc)
            )
            currentScreen = 2
        }
        2 -> {
            CommonScreen(
                image = painterResource(id = R.drawable.lemon_drink), screenText = stringResource(
                    id = R.string.lemonade_to_drink_text
                ), contentDesc = stringResource(id = R.string.lemonade_to_drink_content_desc)
            )
            currentScreen = 3
        }
        3 -> {
            CommonScreen(
                image = painterResource(id = R.drawable.lemon_restart), screenText = stringResource(
                    id = R.string.empty_glass_to_drink_text
                ), contentDesc = stringResource(id = R.string.empty_glass_to_drink_content_desc)
            )
            currentScreen = 0;
        }
        else -> Toast.makeText(context, "No proper screen was found!", Toast.LENGTH_SHORT).show()


    }
}