package com.example.lemonadedemo.core

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonadedemo.R

@Composable
fun LemonadeBox(
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