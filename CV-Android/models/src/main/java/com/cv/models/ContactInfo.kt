package com.cv.models

data class ContactInfo(
    var name : String? = "",
    var addressLines : List<String>? = null,
    var mobileContact : String? = "",
    var emailAddress : String? = "",
    var webAddress : String? = ""
)