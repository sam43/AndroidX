package com.example.looser43.androidx

import android.app.Activity
import android.os.Bundle
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
    }
}