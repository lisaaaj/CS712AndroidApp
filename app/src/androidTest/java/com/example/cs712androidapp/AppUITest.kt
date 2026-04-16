package com.example.cs712androidapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppUITest {

    private lateinit var device: UiDevice

    @Before
    fun setUp() {
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

        // Start from the home screen
        device.pressHome()

        // Launch the app from the launcher
        val context = InstrumentationRegistry.getInstrumentation().context
        val intent = context.packageManager
            .getLaunchIntentForPackage("com.example.cs712androidapp")
        intent?.addFlags(android.content.Intent.FLAG_ACTIVITY_CLEAR_TASK)
        context.startActivity(intent)

        // Wait for the app to appear
        device.wait(
            Until.hasObject(By.pkg("com.example.cs712androidapp").depth(0)),
            3000
        )
    }

    @Test
    fun testNavigateToSecondActivityAndVerifyContent() {
        // Click the "Start Activity Explicitly" button
        val startButton = device.findObject(
            UiSelector().text("Start Activity Explicitly")
        )
        startButton.click()

        // Wait for second activity to load
        device.waitForIdle()

        // Verify at least one challenge is displayed
        val challengeText = device.findObject(
            UiSelector().textContains("Device fragmentation")
        )
        assert(challengeText.exists()) {
            "Expected challenge text not found in second activity"
        }
    }
}

