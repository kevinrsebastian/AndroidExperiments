package com.kevinrsebastian.androidex.test.util

import android.content.res.Resources
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.RecyclerView
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

/**
 * Copy of [Danny Roa's solution](https://github.com/dannyroa/espresso-samples/tree/master/RecyclerView/app/src/androidTest/java/com/dannyroa/espresso_samples/recyclerview)
 * from [this](https://stackoverflow.com/questions/31394569/how-to-assert-inside-a-recyclerview-in-espresso)
 * stackoverflow question.
 *
 * Sample usage:
 * ```
 * // Scroll to the position first
 * onView(withId(R.id.recyclerview_id))
 *     .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(i))
 * // Click a RecyclerView item
 * onView(withRecyclerView(R.id.recyclerview_id).atPosition(i)).perform(click())
 * // Check a RecyclerView item child view
 * onView(withRecyclerView(R.id.recyclerview_id)
 *     .atPositionOnView(i, R.id.title_text)).check(matches(withText("some text")))
 * ```
 */
class RecyclerViewMatcher(@IdRes private val recyclerViewId: Int) {
    companion object {
        fun withRecyclerView(@IdRes recyclerViewId: Int): RecyclerViewMatcher {
            return RecyclerViewMatcher(recyclerViewId)
        }
    }

    fun atPosition(position: Int): Matcher<View?> {
        return atPositionOnView(position, -1)
    }

    fun atPositionOnView(position: Int, @IdRes targetViewId: Int): Matcher<View?> {
        return object : TypeSafeMatcher<View?>() {
            var resources: Resources? = null
            var childView: View? = null

            override fun describeTo(description: Description) {
                var idDescription = recyclerViewId.toString()
                if (resources != null) {
                    idDescription = try {
                        resources!!.getResourceName(recyclerViewId)
                    } catch (var4: Resources.NotFoundException) {
                        String.format("%s (resource name not found)", Integer.valueOf(recyclerViewId))
                    }
                }
                description.appendText("with id: $idDescription")
            }

            override fun matchesSafely(view: View?): Boolean {
                if (view != null) {
                    resources = view.resources
                    if (childView == null) {
                        val recyclerView = view.rootView.findViewById<View>(recyclerViewId) as RecyclerView
                        childView = if (recyclerView.id == recyclerViewId) {
                            recyclerView.findViewHolderForAdapterPosition(position)!!.itemView
                        } else {
                            return false
                        }
                    }
                    return if (targetViewId == -1) {
                        view === childView
                    } else {
                        val targetView = childView!!.findViewById<View>(targetViewId)
                        view === targetView
                    }
                } else {
                    return false
                }
            }
        }
    }
}
