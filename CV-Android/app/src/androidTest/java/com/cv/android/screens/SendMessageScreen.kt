package com.cv.android.screens

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.cv.android.R
import com.cv.android.testhelpers.checkIsVisible
import com.cv.android.testhelpers.click
import com.cv.android.testhelpers.typeText

internal class SendMessageScreen {

    private val nameText = R.id.nameText
    private val emailText = R.id.email
    private val messageText = R.id.message
    private val sendMessageButton = R.id.sendMessageButton
    private val errorMessage = R.id.errorMessage
    private val sentMessage = R.id.successMessage

    fun typeName(text : String) {
        nameText.typeText(text)
    }

    fun typeEmail(text : String) {
        emailText.typeText(text)
    }

    fun typeMessage(text : String) {
        messageText.typeText(text)
    }

    fun clickSentButton() {
        onView(withId(sendMessageButton)).perform(ViewActions.closeSoftKeyboard())

        sendMessageButton.click()
    }

    fun cheeckSentMessageVisible() {
        sentMessage.checkIsVisible()
    }

    fun cheeckErrorMessageVisible() {
        errorMessage.checkIsVisible()
    }
}