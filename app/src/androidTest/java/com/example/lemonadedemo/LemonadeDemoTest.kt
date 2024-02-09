package com.example.lemonadedemo

import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.printToLog
import androidx.test.core.app.ApplicationProvider
import com.example.lemonadedemo.core.CommonScreen
import org.junit.Rule
import org.junit.Test

class LemonadeDemoSuite {
    @get:Rule
    val composeTestRule = createComposeRule()
    val targetContext = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun testBasicTest() {
        val elemText = "This is base Compose test"
        composeTestRule.setContent {
            Text(text = elemText)
        }

        composeTestRule.onNodeWithText(elemText).assertIsDisplayed()
    }

    @Test
    fun testLemonadeBoxInteraction() {
        composeTestRule.setContent {
            CommonScreen()
        }
        val getResourceId: (Context, Int) -> String = { ctx, resource ->
            ctx.resources.getString(resource);
        }

        val imageNode = composeTestRule.onNodeWithContentDescription(
            getResourceId(
                targetContext,
                R.string.lemon_tree_content_desc
            )
        )
        imageNode.printToLog("currentLabelExists")
        imageNode.assertIsDisplayed()
//        composeTestRule.onRoot()
    }
}