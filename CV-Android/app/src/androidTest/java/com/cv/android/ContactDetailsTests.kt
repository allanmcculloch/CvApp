package com.cv.android

import androidx.test.rule.ActivityTestRule
import com.cv.android.screens.ContactDetailsScreen
import com.cv.android.screens.MenuScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ContactDetailsTests {
    private val menuScreen = MenuScreen()
    private val contactDetailsScreen = ContactDetailsScreen()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        menuScreen.openContactDetailsMenu()
    }

    @Test
    fun checkContactDetailsLoad() {
        //TODO: handle network delay with Rx Idling Resource or mock server

        contactDetailsScreen.checkNameHasText("Allan McCulloch")
        contactDetailsScreen.checEmailHasText("allan@hotcross.co.uk")
        contactDetailsScreen.checkAddressHasText("42 My Street, London, E1 1AB")
        contactDetailsScreen.checkMobileHasText("0712345678")
        contactDetailsScreen.checkWebAddressHasText("https://www.linkedin.com/in/allanmcculloch")
    }
}
