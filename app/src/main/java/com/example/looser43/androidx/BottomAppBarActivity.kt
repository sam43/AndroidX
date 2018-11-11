package com.example.looser43.androidx

import android.os.Bundle

class BottomAppBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_bottom_app_bar)
        // Hide navigation drawer icon
        bottom_app_bar.navigationIcon = ContextCompat.getDrawable(this, ic_menu_white_24dp)
        // Move FAB from the center of BottomAppBar to the end of it
        //bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END
        // Replace the action menu
        bottom_app_bar.replaceMenu(bottom_app_bar_secondary)
        bottom_app_bar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.app_bar_mail -> "Home menu item is clicked!".toast(this@BottomAppBarActivity)
                R.id.app_bar_delete -> "Dashboard menu item is clicked!".toast(this@BottomAppBarActivity)
                //R.id.app_bar_archieve -> "Notifications item is clicked!".toast(this@BottomAppBarActivity)
                //R.id.app_bar_more -> "More menu item is clicked!".toast(this@BottomAppBarActivity)
            }
            return@setOnMenuItemClickListener true
        }
        // Change FAB icon
        fab?.setImageDrawable(ContextCompat.getDrawable(this, ic_reply_white_24dp))
    }
}
