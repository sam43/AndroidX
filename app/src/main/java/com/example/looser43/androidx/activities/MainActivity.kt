package com.example.looser43.androidx.activities

import android.content.Intent
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.looser43.androidx.R
import com.example.looser43.androidx.utils.Utils
import kotlinx.android.synthetic.main.test.*


class MainActivity : ThemeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        button.setOnClickListener {
            Utils.setTheme(applicationContext, 1)
            recreateActivity()
        }
        button_n.setOnClickListener {
            //textInputLayout.boxStrokeColor = ContextCompat.getColor(this@MainActivity,android.R.color.white)
            textInputLayout.boxBackgroundColor = ContextCompat.getColor(this@MainActivity, android.R.color.white)
            Utils.setTheme(applicationContext, 2)
            recreateActivity()
        }


    }

    private fun recreateActivity() {
        finish()
        val intent = intent
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        overridePendingTransition(0, 0)
        startActivity(intent)
        overridePendingTransition(0, 0)
    }
}
