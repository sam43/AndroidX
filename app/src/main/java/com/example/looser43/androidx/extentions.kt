package com.example.looser43.androidx

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics

fun Any.toast(context: Context): Toast {
    val toast = Toast.makeText(context, this.toString(), Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.BOTTOM, 0, 600)
    toast.show()
    return toast
}

fun Activity.sendToAnalytics(analytics: FirebaseAnalytics, view: String) {
    val params = Bundle()
    params.putString("screen_name", this::class.java.simpleName)
    params.putString("view_name", view)
    analytics.logEvent("Log_event", params)
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.visible() {
    visibility = View.VISIBLE
}