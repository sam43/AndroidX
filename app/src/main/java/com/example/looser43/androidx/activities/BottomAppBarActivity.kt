package com.example.looser43.androidx.activities

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.looser43.androidx.R
import com.example.looser43.androidx.R.drawable.*
import com.example.looser43.androidx.R.menu.bottom_app_bar_secondary
import com.example.looser43.androidx.R.menu.bottom_menu_search
import com.example.looser43.androidx.fragments.BottomNavigationDrawerFragment
import com.example.looser43.androidx.utils.toast
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*

class BottomAppBarActivity : AppCompatActivity() {

    private var switched: Boolean = false
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)
        fabOpen = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_show)
        fabClose = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_hide)
        sw_toggle.setOnCheckedChangeListener { _, isChecked ->
            switched = isChecked
            this.overridePendingTransition(android.R.anim.fade_in,
                    android.R.anim.fade_out)
            setupBottomNavigation()
        }

    }

    private fun setupBottomNavigation() {
        if (!switched) {
            fab?.startAnimation(fabOpen)
            bottom_app_bar.navigationIcon = ContextCompat.getDrawable(this, ic_menu_white_24dp)
            bottom_app_bar.replaceMenu(bottom_menu_search)
            // Move FAB from the center of BottomAppBar to the end of it
            bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            // Change FAB icon
            fab?.backgroundTintList = (ColorStateList.valueOf(ContextCompat.getColor(this@BottomAppBarActivity, android.R.color.white)))
            fab?.setImageResource(ic_add_24dp)
            fab?.rippleColor = ContextCompat.getColor(this@BottomAppBarActivity, R.color.colorAccent)

        } else {
            fab?.startAnimation(fabClose)
            // Hide navigation drawer icon
            bottom_app_bar.navigationIcon = null
            // Move FAB from the center of BottomAppBar to the end of it
            bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
            // Replace the action menu
            bottom_app_bar.setNavigationOnClickListener {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
            bottom_app_bar.replaceMenu(bottom_app_bar_secondary)
            bottom_app_bar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.app_bar_mail -> "Home menu item is clicked!".toast(this@BottomAppBarActivity)
                    R.id.app_bar_delete -> "Dashboard menu item is clicked!".toast(this@BottomAppBarActivity)
                    R.id.app_bar_archieve -> "Notifications item is clicked!".toast(this@BottomAppBarActivity)
                    //R.id.app_bar_more -> "More menu item is clicked!".toast(this@BottomAppBarActivity)
                }
                return@setOnMenuItemClickListener true
            }
            // Change FAB icon
            fab?.backgroundTintList = (ColorStateList.valueOf(ContextCompat.getColor(this@BottomAppBarActivity, R.color.colorAccent)))
            fab?.setImageResource(ic_reply_white_24dp)
            fab?.rippleColor = ContextCompat.getColor(this@BottomAppBarActivity, R.color.colorPrimary)
        }
    }
}