package com.example.agriconnect

import android.app.PendingIntent.getActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.agriconnect.databinding.ActivitySignUpBinding

class SignUp : AppCompatActivity() {

    lateinit var binding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        var email:String
        var name:String
        var Sirname:String
        var password:String
        var renterpassword:String
        var phone:String

        binding.SignId.setOnClickListener() {

            email = binding.signUpEmailId.getText().toString();
            name = binding.signUpFirstName.getText().toString();
            Sirname = binding.signUpLastName.getText().toString();
            password = binding.SignUpPassword.getText().toString();
            renterpassword = binding.signUpRenterPassword.getText().toString();
            phone = binding.signUpPhoneNo.getText().toString();

            Toast.makeText(applicationContext, email, Toast.LENGTH_LONG).show();
            Toast.makeText(applicationContext, phone, Toast.LENGTH_LONG).show();
            Toast.makeText(applicationContext, name, Toast.LENGTH_LONG).show();
            Toast.makeText(applicationContext, Sirname, Toast.LENGTH_LONG).show();
            Toast.makeText(applicationContext, password, Toast.LENGTH_LONG).show();
            Toast.makeText(applicationContext, renterpassword, Toast.LENGTH_LONG).show();

        }



    }
}