package com.example.lemonadedemo.helpers

import android.content.Context
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.onNodeWithContentDescription


val getResourceId: (Context, Int) -> String = { ctx, resource ->
    ctx.resources.getString(resource);
}

val getNodeFromResource: (ComposeTestRule, Context, Int) -> SemanticsNodeInteraction = { rule, ctx, resource ->
    rule.onNodeWithContentDescription(getResourceId(
        ctx,
        resource
    ))
}