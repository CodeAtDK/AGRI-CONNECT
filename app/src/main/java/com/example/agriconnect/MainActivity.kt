package com.example.agriconnect

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.BindingMethod
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.agriconnect.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()



        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonSignIn.setOnClickListener(){

            val intent = Intent(this@MainActivity,SignIn::class.java)
            startActivity(intent)
        }
        binding.buttonSignUpp.setOnClickListener(){

            val intent = Intent(this@MainActivity,SignUp::class.java)
            startActivity(intent)
        }


    }
}