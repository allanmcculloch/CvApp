package com.cv.models

data class Job(
    var company : String,
    var title : String,
    var description : String? = null,
    var period : String? = null,
    var location : String?
)
