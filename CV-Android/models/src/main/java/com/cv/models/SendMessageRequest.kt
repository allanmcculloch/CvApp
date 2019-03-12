package com.cv.models

data class SendMessageRequest(
    var name : String,
    var fromEmail : String,
    var message : String
)