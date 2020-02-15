package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.list.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding;
    private lateinit var drawerLayout: DrawerLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       
        //BINDING REFERENCE TO MAIN ACTIVITY LAYOUT
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)



        //ATTACH BUTTON (HAMBURGER) DRAWER TO LAYOUT
        drawerLayout = binding.drawerLayout

        
        //Link the navigation controller to the app navbar
        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)



        //DRAWER


        //INTRODUCE DRAWER(navView) TO NAVIGATION AND LINK THEM
        NavigationUI.setupWithNavController(binding.navView, navController);


    }

    //NAVIGATE UP WHEN ARROW IN NAVBAR IS PRESSED
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }


}
