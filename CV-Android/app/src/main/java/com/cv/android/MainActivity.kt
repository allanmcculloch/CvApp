package com.cv.android

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            findNavController(R.id.nav_host_fragment).navigate(R.id.contactFragment)
            fab?.hide()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        fab.show()

        when (item.itemId) {
            R.id.nav_contact_info -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.contactInfoFragment)
            }
            R.id.nav_experience -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.jobListFragment)
            }
            R.id.nav_mypics -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.photosFragment)
            }
            R.id.nav_contact_me -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.contactFragment)
                fab?.hide()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}