package com.cv.android

import androidx.test.rule.ActivityTestRule
import com.cv.android.screens.JobListScreen
import com.cv.android.screens.MenuScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class JobsListTests {
    private val menuScreen = MenuScreen()
    private val jobsListScreen = JobListScreen()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        menuScreen.openJobsListMenu()
    }

    @Test
    fun checkContactDetailsLoad() {
        //TODO: handle network delay with Rx Idling Resource or mock server

        jobsListScreen.checkPositionHasText("Just Eat Plc.",0)
        jobsListScreen.checkPositionHasText("London",0)

        jobsListScreen.checkPositionHasText("Fraedom, HRG Plc.",1)
        jobsListScreen.checkPositionHasText("London",1)
    }
}
