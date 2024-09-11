package com.example.agriconnect.Basic

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.agriconnect.Farmer_Main.FarmerMainActivity
import com.example.agriconnect.R
import com.example.agriconnect.databinding.ActivitySignUpBinding
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth
import com.google.firebase.firestore.firestore

class SignUp : AppCompatActivity()  {

    // Data Binding
    lateinit var binding: ActivitySignUpBinding

    // Firebase Authentication
    private lateinit var auth: FirebaseAuth

    // Firebase storage
    private val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // This will bind the class to activity_sign_up
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)

        // ...
        // Initialize Firebase Auth
        FirebaseApp.initializeApp(this)

        auth = Firebase.auth






        // Will call createUser
        binding.SignId.setOnClickListener() {

            createUser();

        }
    }

    // will take email and password form user and then check in database it exist or not if not then create a new user
    private fun createUser() {

        val email = binding.signUpEmailId.text.toString()
        val password = binding.signUpRenterPassword.text.toString()


        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    updateUI(null)
                }
            }
    }

    // after creating new user it will update the UI

    private fun updateUI(user: FirebaseUser?) {


        if (user != null) {

           // adddata();
            val intent = Intent(this, FarmerMainActivity::class.java)
            startActivity(intent)
        }



    }

    // This will add the data to firebase firestore database of user Detail
    private fun adddata() {


        val email1:String = binding.signUpEmailId.text.toString()
        val name:String = binding.signUpFirstName.text.toString()
        val sirname:String = binding.signUpLastName.text.toString()
        val phone:Int = binding.signUpPhoneNo.text.toString().toInt()

        val user = userinformation(
            name,
            sirname,
            email1,
            phone,
        )
//
        db.collection("userinformation").document("$email1").set(user)
    }

    // On start it will initialize the value of auth
    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            reload()
        }


    }

    private fun reload() {

    }




}