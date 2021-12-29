package com.trinitywizards.data

import java.io.Serializable

data class Contact (
    var id: String,
    var firstName: String,
    var lastName: String,
    var email: String,
    var phone: String

) : Serializable {
    constructor(): this(
        "",
        "",
        "",
        "",
        ""
    )
}