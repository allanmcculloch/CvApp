package com.cv.android.screens

import androidx.test.espresso.matcher.ViewMatchers
import com.cv.android.R
import com.cv.android.testhelpers.checkHasText
import com.cv.android.testhelpers.waitForMatcher
import org.hamcrest.Matchers

internal class ContactDetailsScreen {
    private val name = R.id.name
    private val email = R.id.email
    private val address = R.id.address
    private val mobile = R.id.mobile
    private val webAddress = R.id.webAddress

    fun checkNameHasText(text : String) {
        name.checkHasText(text)
    }

    fun checEmailHasText(text : String) {
        email.checkHasText(text)
    }

    fun checkAddressHasText(text : String) {
        address.checkHasText(text)
    }

    fun checkMobileHasText(text : String) {
        mobile.checkHasText(text)
    }

    fun checkWebAddressHasText(text : String) {
        webAddress.checkHasText(text)
    }

    fun hasLoadedAndNameHasText(text: String)
    {
        name.waitForMatcher(
            Matchers.allOf(
                ViewMatchers.isDisplayed(),
                ViewMatchers.withText(Matchers.containsString(text))
            ))
    }
}