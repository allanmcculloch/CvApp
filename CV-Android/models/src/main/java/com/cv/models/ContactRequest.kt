package com.cv.models

data class ContactRequest(
    var name : String,
    var fromEmail : String,
    var subject : String,
    var message : String
)