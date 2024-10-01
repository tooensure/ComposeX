package com.example.composex

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.composex.ui.theme.ComposeXTheme
import org.junit.Rule
import org.junit.Test

class PrimaryButtonTest {

    // Use createAndroidComposeRule if you need activity access, or createComposeRule otherwise
//    @get:Rule
//    val composeTestRule = createComposeRule()
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testButtonClickShowsWelcomeText() {
        // Set the content of the test
        composeTestRule.setContent {
            // Assuming you have a custom theme ComposeXTheme
            MaterialTheme {
                // Assuming MainScreen has a button with the text "Continue"
                // and after clicking it, a text "Welcome" should appear
//                MainScreen(uiState = fakeUiState) // Replace with your actual UI composable
            }
        }

        // Find a button with text "Continue" and click it
        composeTestRule.onNodeWithText("Continue").performClick()

        // Check if the "Welcome" text is displayed
        composeTestRule.onNodeWithText("Welcome").assertIsDisplayed()
    }
}