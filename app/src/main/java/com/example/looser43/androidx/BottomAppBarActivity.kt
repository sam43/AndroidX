package com.example.looser43.androidx

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.looser43.androidx.R.drawable.ic_menu_white_24dp
import com.example.looser43.androidx.R.drawable.ic_reply_white_24dp
import com.example.looser43.androidx.R.menu.bottom_app_bar_secondary
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*

class BottomAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_app_bar)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        bottom_app_bar.navigationIcon = ContextCompat.getDrawable(this, ic_menu_white_24dp)
        bottom_app_bar.setNavigationOnClickListener {
            val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
        }
        // Move FAB from the center of BottomAppBar to the end of it
        //bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        // Replace the action menu
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
        fab?.setImageDrawable(ContextCompat.getDrawable(this, ic_reply_white_24dp))
    }
}