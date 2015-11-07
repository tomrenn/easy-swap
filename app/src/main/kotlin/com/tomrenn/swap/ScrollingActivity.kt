package com.tomrenn.swap

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import butterknife.bindView
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
import timber.log.Timber

class ScrollingActivity : AppCompatActivity(), MainCallbacks {
    val GOOGLE_SIGN_IN = 0;
    val appBar : AppBarLayout by bindView(R.id.app_bar)
    val coordinator: CoordinatorLayout by bindView(R.id.coordinator)
    val fragmentContainer : FrameLayout by bindView(R.id.fragmentContainer)
    val fab : FloatingActionButton by bindView(R.id.fab)


    override fun googleSignIn(googleSignInAccount: GoogleSignInAccount) {
        // change off welcome fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
//        val toolbar = findViewById(R.id.toolbar) as Toolbar
//        setSupportActionBar(toolbar)
        appBar.visibility = View.GONE;
        fab.visibility = View.GONE;

        greetings(coordinator)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, WelcomeFragment())
            .commit()

        fab.setOnClickListener(){ view ->
//            val intent = Intent(this@ScrollingActivity, EditActivity::class.java);
//            startActivity(intent);
        }
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
