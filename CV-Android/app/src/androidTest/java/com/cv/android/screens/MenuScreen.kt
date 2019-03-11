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

    fun clickContactDetailsMenu() {
        onView(withText(R.string.drawer_contact_info)).perform(click())
    }

    fun clickJobsListMenu() {
        onView(withText(R.string.drawer_professional_experience)).perform(click())
    }

    fun clickMyPictures() {
        onView(withText(R.string.drawer_my_pictures)).perform(click())
    }

    fun clickContact() {
        onView(withText(R.string.drawer_contact_me)).perform(click())
    }
}