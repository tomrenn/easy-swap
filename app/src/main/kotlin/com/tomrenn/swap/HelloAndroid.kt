package com.tomrenn.swap

import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar

/**
 *
 */

fun greetings(container: CoordinatorLayout) {
    Snackbar.make(container, "Greetings!", Snackbar.LENGTH_LONG)
            .show();

}

