package com.example.looser43.androidx

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast

fun Any.toast(context: Context): Toast {
    return Toast.makeText(context, this.toString(), Toast.LENGTH_SHORT).apply { show() }
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