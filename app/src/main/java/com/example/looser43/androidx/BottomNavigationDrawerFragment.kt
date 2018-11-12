package com.example.looser43.androidx

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_bottomsheet.*

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /*navigation_view.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem.itemId) {
                R.id.nav1 -> "Item 1".toast(context!!)
                R.id.nav2 -> "Item 2".toast(context!!)
                R.id.nav3 -> "Item 3".toast(context!!)
            }
            true
        }*/
        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            // Bottom Navigation Drawer menu item clicks
            when (menuItem.itemId) {
                R.id.nav1 -> "Item 1".toast(context!!)
                R.id.nav2 -> "Item 2".toast(context!!)
                R.id.nav3 -> "Item 3".toast(context!!)
                R.id.nav4 -> "Item 4".toast(context!!)
                R.id.nav5 -> "Item 5".toast(context!!)
            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here
            true
        }
    }
}
