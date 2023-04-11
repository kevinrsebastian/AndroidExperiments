package com.kevinrsebastian.androidex

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kevinrsebastian.androidex.directory.DirectoryActivity
import com.kevinrsebastian.androidex.test.base.BaseInstrumentationTest
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
internal class MainActivityTest : BaseInstrumentationTest() {
    private lateinit var scenario: ActivityScenario<MainActivity>

    @After
    override fun tearDown() {
        Intents.release()
        scenario.close()
    }

    @Test
    fun launchScreen() {
        scenario = launchActivity()
        Intents.intended(IntentMatchers.hasComponent(DirectoryActivity::class.java.name))
        assert(scenario.state == Lifecycle.State.DESTROYED)
    }
}
