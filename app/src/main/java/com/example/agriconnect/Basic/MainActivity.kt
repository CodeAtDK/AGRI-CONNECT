package com.example.agriconnect.Basic

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.agriconnect.Crop_Suggestion.CropReuridments_DataClass
import com.example.agriconnect.Farmer_Main.FarmerMainActivity
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.Farmer_Market.FarmerProduct
import com.example.agriconnect.Farmer_Market.MarketDiscription.Product_Details
import com.example.agriconnect.GovernmentSchemes.GovernmentSchemes
import com.example.agriconnect.New_Crop.New_Farming_Crop_Data_Class
import com.example.agriconnect.New_Techniques.New_Techniques_Data_Class
import com.example.agriconnect.R
import com.example.agriconnect.databinding.ActivityMainBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.storage
import java.io.File
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore
//    val storage = Firebase.storage

    lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // This will bind the kotlin file to activity_main
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)





        // This button will change the activity from main to SignIn
        binding.buttonSignIn.setOnClickListener() {



            // Intent is use to change the activity

            val intent = Intent(this@MainActivity, SignIn::class.java)
            startActivity(intent)
            binding.textView.setTransitionVisibility(View.VISIBLE)
        }

        // This button will change the activity from main to SignUp
        binding.buttonSignUpp.setOnClickListener() {



            // Intent is use to change the activity
            val intent = Intent(this@MainActivity, SignUp::class.java)
            startActivity(intent)
        }

        binding.login.setOnClickListener(){

            val intent = Intent(this@MainActivity, FarmerMainActivity::class.java)
            startActivity(intent)

        }


    }



}


