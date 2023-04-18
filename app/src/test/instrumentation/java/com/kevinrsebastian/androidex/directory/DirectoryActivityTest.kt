package com.kevinrsebastian.androidex.directory

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kevinrsebastian.androidex.R
import com.kevinrsebastian.androidex.test.base.BaseInstrumentationTest
import com.kevinrsebastian.androidex.test.util.RecyclerViewMatcher.Companion.withRecyclerView
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

        // Check directory titles are shown at the proper position
        for (i in 0 until DirectoryActivity.directoryItems.size) {
            val title = DirectoryActivity.directoryItems[i]
            onView(withId(R.id.directory_list))
                .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(i))
            onView(withRecyclerView(R.id.directory_list).atPositionOnView(i, R.id.title_text))
                .check(matches(withText(title)))
        }
    }
}
