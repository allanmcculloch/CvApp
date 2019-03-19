package com.cv.android

import androidx.test.rule.ActivityTestRule
import com.cv.android.screens.MenuScreen
import com.cv.android.screens.PhotosScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PhotosTests {
    private val menuScreen = MenuScreen()
    private val photosScreen = PhotosScreen()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        menuScreen.openMyPictures()
    }

    @Test
    fun checkContactDetailsLoad() {
        //TODO: handle network delay with Rx Idling Resource or mock server

        photosScreen.checkPositionHasText("Ben Wyvis, Scotland (Final Munro)",0)

        photosScreen.checkPositionHasText("Mont Blanc",1)
    }
}
