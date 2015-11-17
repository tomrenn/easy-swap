package com.tomrenn.swap

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.bindView
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
import timber.log.Timber

/**
 *
 */
class WelcomeFragment : Fragment(), OnConnectionFailedListener {
    val GOOGLE_SIGN_IN = 0;
    val googleSignIn: SignInButton by bindView(R.id.googleSignIn)
    lateinit var googleApiClient: GoogleApiClient
    lateinit var mainCallbacks : MainCallbacks


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_welcome, container, false);
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        googleApiClient = buildGoogleClient()
        val parentActivity = activity
        if (parentActivity is MainCallbacks) {
            mainCallbacks = parentActivity;
        } else {
            throw IllegalStateException("Parent activity must implement MainCallback")
        }

        googleSignIn.setStyle(SignInButton.SIZE_WIDE, SignInButton.COLOR_AUTO)
        googleSignIn.setOnClickListener { signIn() }
    }

    fun signIn() {
        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        startActivityForResult(signInIntent, GOOGLE_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == GOOGLE_SIGN_IN) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess) {
                val acct = result.signInAccount
                // Get account information
                Timber.d(acct.displayName)
                Timber.d(acct.email)
                Timber.d(acct.photoUrl.toString())
                mainCallbacks.googleSignIn(acct)
            }
        }
    }

    fun buildGoogleClient() : GoogleApiClient {
        // Configure sign-in to request the user's ID, email address, and basic profile. ID and
        // basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        // Build a GoogleApiClient with access to GoogleSignIn.API and the options above.
        return GoogleApiClient.Builder(activity)
                .enableAutoManage(activity, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    override fun onConnectionFailed(p0: ConnectionResult?) {
        throw UnsupportedOperationException()
    }
}