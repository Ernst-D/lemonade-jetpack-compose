package com.example.lemonadedemo.core

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadedemo.R
import com.example.lemonadedemo.content.getLemonadeContent

@Composable
fun LemonadeBox(
    modifier: Modifier,
) {
    val context = LocalContext.current
    var currentScreen by remember {
        mutableStateOf(0)
    }

    var squeezeNumber by remember {
        mutableStateOf(0)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                colorResource(id = R.color.lemonade_box_background),
                shape = RoundedCornerShape(16.dp)
            )
            .size(250.dp, 250.dp)
            .clickable {
                when (true) {
                    (currentScreen == 0) -> {
                        squeezeNumber = (2..4).random()
                        currentScreen++
                    }

                    (currentScreen == 1 && squeezeNumber > 0) -> {
                        squeezeNumber--
                        currentScreen = 1
                    }

                    (currentScreen == 3) -> {
                        currentScreen = 0
                    }

                    else -> {
                        currentScreen++
                    }
                }

                Toast
                    .makeText(
                        context,
                        "Squeeze $squeezeNumber / Screen $currentScreen",
                        Toast.LENGTH_SHORT
                    )
                    .show()
            }
    ) {
        Image(
            painter = painterResource(id = getLemonadeContent(currentScreen).image),
            contentDescription = stringResource(id = getLemonadeContent(currentScreen).contentDesc)
        )
    }
    Text(
        text = stringResource(id = getLemonadeContent(currentScreen).textContent),
        modifier = Modifier.padding(vertical = 20.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun LemonadeBoxPreview() {
    LemonadeBox(
        modifier = Modifier
    )
}