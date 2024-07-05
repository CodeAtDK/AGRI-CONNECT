package com.example.agriconnect.Farmer_Main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.agriconnect.Basic.MainActivity
import com.example.agriconnect.R
import com.google.android.material.navigation.NavigationView
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class FarmerMainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.farmer_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        // ...
        // Initialize Firebase Auth
        auth = Firebase.auth

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
        setSupportActionBar(toolbar)

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val toogle = ActionBarDrawerToggle(this,drawerLayout,toolbar,
            R.string.open_nav,
            R.string.close_nav
        )
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        if(savedInstanceState == null){
            replaceFragment(Home())
            navigationView.setCheckedItem(R.id.nav_home)
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.nav_home -> replaceFragment(Home())
            R.id.nav_Log_Out -> finish()

        }
    drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }

    override fun finish(){

        Firebase.auth.signOut()

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }



    fun replaceFragment(fragment: Fragment){

        val transition: FragmentTransaction = supportFragmentManager.beginTransaction()
        transition.replace(R.id.fragment_container,fragment)
        transition.commit()

    }


    override fun onBackPressed() {
        super.onBackPressed()


        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START)
        }
        else{
            onBackPressedDispatcher.onBackPressed()
        }
    }


}