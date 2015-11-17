package com.tomrenn.swap.edit

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.SpannedString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import butterknife.bindView
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.tomrenn.swap.MainCallbacks
import com.tomrenn.swap.R
import com.tomrenn.swap.ScrollingActivity


val NAME = "name";
val EMAIL = "email";
val IMG_URL = "imgUrl";

fun createEditFragmentInstance(googleSignInAccount: GoogleSignInAccount): EditFragment {
    val args = Bundle()
    args.putString(NAME, googleSignInAccount.displayName)
    args.putString(EMAIL, googleSignInAccount.email)
    args.putString(IMG_URL, googleSignInAccount.photoUrl?.toString())

    val fragment = EditFragment()
    fragment.arguments = args
    return fragment
}


/**
 *
 */
class EditFragment : Fragment() {
    // profileManager
    val nameField: EditText by bindView(R.id.name)
    val taglineField: EditText by bindView(R.id.tagline)
    val emailField: EditText by bindView(R.id.email)
    val phoneField: EditText by bindView(R.id.phone)


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_edit_profile, container, false);
        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args = if (arguments != null) arguments else Bundle()
        nameField.setText(args.getString(NAME))
        emailField.setText(args.getString(EMAIL));

//        val activity = activity;
//        if (activity is MainCallbacks) {
//            activity.
//        }
    }


}