package com.tomrenn.swap

import com.google.android.gms.auth.api.signin.GoogleSignInAccount

/**
 *
 */
interface MainCallbacks {
    fun googleSignIn(googleSignInAccount: GoogleSignInAccount)
}