package com.cv.android.screens

import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import com.cv.android.R
import org.hamcrest.Description
import org.hamcrest.Matcher


internal class JobListScreen {

    private val jobsList = R.id.jobsListRecyclerView

    fun checkPositionHasText(text : String, position : Int) {

        checkText(text, position)
    }

    private fun checkText(text: String, position : Int) {
        onView(withId(jobsList))
            .check(matches(atPosition(position, hasDescendant(withText(text)))))
    }

    private fun atPosition(position: Int, @NonNull itemMatcher: Matcher<View>): Matcher<View> {
        checkNotNull(itemMatcher)
        return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has item at position $position: ")
                itemMatcher.describeTo(description)
            }

            override fun matchesSafely(view: RecyclerView): Boolean {
                val viewHolder = view.findViewHolderForAdapterPosition(position)
                    ?: // has no item on such position
                    return false
                return itemMatcher.matches(viewHolder.itemView)
            }
        }
    }
}