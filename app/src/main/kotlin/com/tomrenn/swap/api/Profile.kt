package com.tomrenn.swap.api

/**
 *
 */
data class Profile(
    val name: String,
    val tagline: String = "",
    val imageUrl: String = "",
    val email: String = "",
    val phoneNumber: String = "",
    // social
    val linkedIn: String = "",
    val twitter: String = "",
    val website: String = ""
)
