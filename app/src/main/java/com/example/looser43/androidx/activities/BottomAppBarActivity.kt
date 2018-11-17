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
import com.example.looser43.androidx.utils.getFCMtoken
import com.example.looser43.androidx.utils.toast
import com.google.android.material.bottomappbar.BottomAppBar
import kotlinx.android.synthetic.main.activity_bottom_app_bar.*
import kotlinx.android.synthetic.main.content_main.*
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig


class BottomAppBarActivity : AppCompatActivity() {

    private var switched: Boolean = false
    private var first: Boolean = false
    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    private lateinit var fabFade: Animation
    private lateinit var fabFadeO: Animation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getFCMtoken()
        //subscribeToFCMTopic("sayem")
        first = true
        setContentView(R.layout.activity_bottom_app_bar)
        fabOpen = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_show)
        fabClose = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_hide)
        fabFade = AnimationUtils.loadAnimation(applicationContext, android.R.anim.fade_in)
        fabFadeO = AnimationUtils.loadAnimation(applicationContext, android.R.anim.fade_out)
        sw_toggle.setOnCheckedChangeListener { _, isChecked ->
            switched = isChecked
            bottom_app_bar?.startAnimation(fabFadeO)
            setupBottomNavigation()
        }
        if (first) {
            first = false
            showTutorials()
            setupBottomNavigation()
            bottom_app_bar.setNavigationOnClickListener {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
    }

    private fun showTutorials() {
        // sequence example
        val config = ShowcaseConfig()
        config.delay = 500 // half second between each showcase view

        val sequence = MaterialShowcaseSequence(this, "s_1")

        sequence.setConfig(config)

        sequence.addSequenceItem(sw_toggle,
                "This is button one", "GOT IT")

        sequence.addSequenceItem(fab,
                "This is button two", "GOT IT")

        sequence.addSequenceItem(bottom_app_bar,
                "This is button three", "GOT IT")

        sequence.start()

    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

    private fun setupBottomNavigation() {
        if (!switched) {
            fab?.startAnimation(fabOpen)
            bottom_app_bar?.startAnimation(fabFade)
            bottom_app_bar.navigationIcon = ContextCompat.getDrawable(this, ic_menu_white_24dp)
            bottom_app_bar.replaceMenu(bottom_menu_search)
            // Move FAB from the center of BottomAppBar to the end of it
            bottom_app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            // Change FAB icon
            fab?.backgroundTintList = (ColorStateList.valueOf(ContextCompat.getColor(this@BottomAppBarActivity, android.R.color.white)))
            fab?.setImageResource(ic_add_24dp)
            fab?.rippleColor = ContextCompat.getColor(this@BottomAppBarActivity, R.color.colorAccent)
            // Fab onClick Listener
            //fab?.setOnClickListener { animateTest() }

        } else {
            fab?.startAnimation(fabClose)
            bottom_app_bar?.startAnimation(fabFade)
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