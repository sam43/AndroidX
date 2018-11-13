package com.example.looser43.androidx.utils

import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.animation.Animation
import android.widget.Toast
import com.google.android.material.internal.NavigationMenuView
import com.google.android.material.navigation.NavigationView
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

fun disableScrollbar(navigationView: NavigationView) {
    val navigationMenuView = navigationView.getChildAt(0) as NavigationMenuView
    navigationMenuView.isVerticalScrollBarEnabled = false
}

fun animateTest(view: View) {
    val anim = ValueAnimator.ofFloat(0F, 1F)
    anim.duration = 2000

    val hsv = FloatArray(3)
    var runColor: Int
    // Transition color
    hsv[1] = 1f
    hsv[2] = 1f
    anim.addUpdateListener { animation ->
        hsv[0] = 360 * animation.animatedFraction

        runColor = Color.HSVToColor(hsv)
        view.setBackgroundColor(runColor)
    }

    anim.repeatCount = Animation.INFINITE

    anim.start()
}