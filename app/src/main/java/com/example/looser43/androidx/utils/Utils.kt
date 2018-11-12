package com.example.looser43.androidx.utils

import android.app.Activity
import android.os.Bundle
import android.view.ViewAnimationUtils
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.analytics.FirebaseAnalytics


class Utils {
    companion object {

        fun sendToAnalytics(analytics: FirebaseAnalytics, activity: Activity, view: String) {
            val params = Bundle()
            params.putString("screen_name", activity::class.java.simpleName)
            params.putString("view_name", view)
            params.putString("count", "")
            analytics.logEvent("Log_event", params)
        }

        fun toggleFabMenu(fab: FloatingActionButton) {
            val centerX = fab.width / 2
            val centerY = fab.height / 2
            val startRadius = 0
            val endRadius = Math.hypot(fab.width.toDouble(), fab.height.toDouble()).toInt() / 2

            //fab.visibility = View.VISIBLE
            ViewAnimationUtils
                    .createCircularReveal(
                            fab,
                            centerX,
                            centerY,
                            startRadius.toFloat(),
                            endRadius.toFloat()
                    )
                    .setDuration(500)
                    .start()

            //fabMenuOpen = !fabMenuOpen
        }

    }
}