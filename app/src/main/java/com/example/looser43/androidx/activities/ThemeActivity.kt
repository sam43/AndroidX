package com.example.looser43.androidx.activities

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.looser43.androidx.R
import com.example.looser43.androidx.utils.Utils


@SuppressLint("Registered")
open class ThemeActivity : AppCompatActivity() {
    companion object {
        const val THEME_BLUE = 1
        const val THEME_NIGHT = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateTheme()
    }

    private fun updateTheme() {
        if (Utils.getTheme(applicationContext) <= THEME_BLUE) {
            setTheme(R.style.AppTheme)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = ContextCompat.getColor(this, R.color.colorPrimaryDark)
            }
        } else if (Utils.getTheme(applicationContext) == THEME_NIGHT) {
            setTheme(R.style.AppTheme_Night)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = ContextCompat.getColor(this, R.color.primaryColorDark_night)
            }
        }
    }
}
