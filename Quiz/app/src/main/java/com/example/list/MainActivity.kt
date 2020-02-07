package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.list.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ADD BACK BUTTON
        val navController = this.findNavController(R.id.myNavHostFragment)
        //Link the navigation controller to the app navbar
        NavigationUI.setupActionBarWithNavController(this,navController)
        
        

    }

    //NAVIGATE UP WHEN ARROW IN NAVBAR IS PRESSED
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }




}
