package com.tomrenn.swap.api

/**
 *
 */
class Message {

    data class ProfileBroadcast(
            val profile: Profile,
            val shared: List<String>
    )
}