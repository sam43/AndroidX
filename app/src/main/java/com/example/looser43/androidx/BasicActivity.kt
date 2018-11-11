package com.example.looser43.androidx

import android.os.Bundle
import android.util.Log


class BasicActivity : AppCompatActivity() {
    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                Utils.sendToAnalytics(mFirebaseAnalytics!!, this@BasicActivity, "basic_act_home")
                message.setText(R.string.title_home)
                Log.d("bottom", "data: HOME")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                Utils.sendToAnalytics(mFirebaseAnalytics!!, this@BasicActivity, "basic_act_dashboard")
                message.setText(R.string.title_dashboard)
                Log.d("bottom", "data: Dash")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                Utils.sendToAnalytics(mFirebaseAnalytics!!, this@BasicActivity, "basic_act_noti")
                message.setText(R.string.title_notifications)
                Log.d("bottom", "data: NOTI")
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_more -> {
                //throw NullPointerException("this is a null exception")
                Utils.sendToAnalytics(mFirebaseAnalytics!!, this@BasicActivity, "basic_act_more")
                message.setText(R.string.title_more)
                Log.d("bottom", "data: MORE")
                //return@OnNavigationItemSelectedListener true

            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        setContentView(R.layout.activity_basic)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
