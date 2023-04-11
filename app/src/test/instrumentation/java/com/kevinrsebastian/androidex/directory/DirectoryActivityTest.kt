package com.kevinrsebastian.androidex.directory

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kevinrsebastian.androidex.test.base.BaseInstrumentationTest
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
internal class DirectoryActivityTest : BaseInstrumentationTest() {
    private lateinit var scenario: ActivityScenario<DirectoryActivity>

    @After
    override fun tearDown() {
        super.tearDown()
        scenario.close()
    }

    @Test
    fun launchScreen() {
        scenario = launchActivity()
    }
}
