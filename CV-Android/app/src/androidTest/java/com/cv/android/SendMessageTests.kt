package com.cv.android

import androidx.test.rule.ActivityTestRule
import com.cv.android.screens.MenuScreen
import com.cv.android.screens.SendMessageScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SendMessageTests {

    private val menuScreen = MenuScreen()
    private val sendMessageScreen = SendMessageScreen()

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        menuScreen.openContact()
    }

    @Test
    fun sendMessageSuccess() {

        //TODO: handle network delay with Rx Idling Resource or mock server

        sendMessageScreen.typeName("Allan McCulloch")
        sendMessageScreen.typeEmail("allan@hotcross.co.uk")
        sendMessageScreen.typeMessage("Just trying out your app! :-)")

        sendMessageScreen.clickSentButton()

        sendMessageScreen.cheeckSentMessageVisible()
    }

    @Test
    fun sendMessageFailed() {

        //TODO: handle network delay with Rx Idling Resource or mock server

        sendMessageScreen.typeName("Allan McCulloch")
        sendMessageScreen.typeEmail("")
        sendMessageScreen.typeMessage("Just letting you know that I am trying your app :-)")

        sendMessageScreen.clickSentButton()

        sendMessageScreen.cheeckErrorMessageVisible()
    }
}
