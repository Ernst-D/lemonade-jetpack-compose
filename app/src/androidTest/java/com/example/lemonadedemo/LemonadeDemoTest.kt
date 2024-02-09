package com.example.lemonadedemo

import android.content.Context
import androidx.compose.material3.Text
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.test.core.app.ApplicationProvider
import com.example.lemonadedemo.core.CommonScreen
import com.example.lemonadedemo.helpers.getNodeFromResource
import org.junit.Rule
import org.junit.Test

class LemonadeDemoSuite {
    @get:Rule
    val composeTestRule = createComposeRule()
    val ctx = ApplicationProvider.getApplicationContext<Context>()

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

        getNodeFromResource(
            composeTestRule,
            ctx,
            R.string.lemon_tree_content_desc
        ).printToLog("currentLabelExists")

        getNodeFromResource(
            composeTestRule,
            ctx,
            R.string.lemon_tree_content_desc
        ).assertIsDisplayed().performClick()

        composeTestRule.waitForIdle()

        getNodeFromResource(
            composeTestRule,
            ctx,
            R.string.keep_tapping_content_desc
        ).assertIsDisplayed()
    }
}