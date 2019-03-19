package com.cv.android.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.cv.android.R

internal class MenuScreen {
    fun openMenu() {
        onView(withId(R.id.drawer_layout)).perform(DrawerActions.open())
    }

    fun openContactDetailsMenu() {
        openMenu()
        onView(withText(R.string.drawer_contact_info)).perform(click())
    }

    fun openJobsListMenu() {
        openMenu()
        onView(withText(R.string.drawer_professional_experience)).perform(click())
    }

    fun openMyPictures() {
        openMenu()
        onView(withText(R.string.drawer_my_pictures)).perform(click())
    }

    fun openContact() {
        openMenu()
        onView(withText(R.string.drawer_contact_me)).perform(click())
    }
}