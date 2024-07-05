package com.example.agriconnect.Basic

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.agriconnect.Farmer_Main.FarmerMainActivity
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

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore
//    val storage = Firebase.storage

    lateinit var binding: ActivityMainBinding
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        // binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)





        binding.buttonSignIn.setOnClickListener() {
//
//
//            val docRef = db.collection("GovernmentSchemes").document("2")
//            docRef.get().addOnSuccessListener { documentSnapshot ->
//                if (documentSnapshot.exists()) {
//                    val data = documentSnapshot.toObject<GovernmentSchemes>(GovernmentSchemes::class.java)
//                    // Access data fields (e.g., val item = data["item"])
//
//                    Log.d("TAG", "DocumentSnapshot data: $data")
//                } else {
//                    // Document does not exist
//                    Log.d("TAG", "DocumentSnapshot does not exist")
//                }
//            }



            val city = New_Techniques_Data_Class(
                "New_Crops/Screenshot 2024-03-13 234256.png",
                "Pearl Farming2" ,
                "All farmers do farming, but nowadays Pearl's farming trend is increasing rapidly. Less labor and higher profits are proving to be a bargain. Till now, training for Pearl farming is given at the Central Institute of Fresh Water Aquaculture, Bhubaneswar (Odisha), but now many other institutes are providing the training in the state.",
                "All farmers do farming, but nowadays Pearl farming trend is increasing rapidly. Less labor and higher profits are proving to be a bargain. Earlier, training for Pearl farming was given at Central Institute of Fresh Water Aquaculture, Bhubaneswar (Odisha), but now many other institutes are providing the training in the state. You can do a simple google search based on your location and chances are there will be an institute for Pearl farming near you.\n" +
                        "\n" +
                        "Benefits of Pearl farming\n" +
                        "There are many benefits of Pearl farming such as youth will get employment & profits are huge in this. This is the reason it is becoming more & more famous these days. Here we will discuss the whole process related to Pearl farming. Let’s start:\n" +
                        "\n" +
                        "\n" +
                        "Advertisement\n" +
                        "\n" +
                        "How to do Pearl Farming\n" +
                        "The most favorable season for pearl cultivation is the time of autumn i.e. October to December. Beads can be cultivated in a pond of at least 10 x 10 feet or larger. For pearl cultivation, pearls can be produced from a maximum of 25000 oysters in a small pond like 0.4 ha. To start farming, the farmer has to collect oysters from ponds, rivers, etc. or they can also be purchased.\n" +
                        "\n" +
                        "The farmer has to collect oysters from ponds, rivers, etc. or they can also be purchased. After this, after every minor operation in each oyster, simple or designed beads with a diameter of four to six mm like Ganesha, Buddha, floral shape, etc. are put inside it. The oyster is then closed. These oysters are kept in nylon bags for 10 days on anti-biotic and natural feed. These are inspected daily and dead oysters are removed.\n" +
                        "\n" +
                        "RELATED LINKS\n" +
                        "UP farmer earns Rs 8 lakh annually with pearl farming\n" +
                        "UP farmer earns Rs 8 lakh annually with pearl farming\n" +
                        "34-year-old Bijender Chauhan is a farmer from Dhampur village in Bijnor district, Uttar Pradesh. Bijender is basically a sugarcane farmer…\n" +
                        "\n" +
                        "\n" +
                        "Oysters are put in the Pond\n" +
                        "Now, these oysters are put in the ponds. For this, they are hung in nylon bags (two oysters per bag) using bamboo or a bottle and left at a depth of one meter in the pond. These can be followed at the rate of 20 thousand to 30 thousand oysters per hectare. The material coming from inside starts to settle around the bead which takes the form of pearl in the end. After about 8-10 months, the oyster is ripped off and the pearl is removed.\n" +
                        "\n" +
                        "Cost & Profits in Pearl Farming\n" +
                        "A single oyster costs around 20 to 30 rupees at a lower cost. The price of one mm to 20 mm oyster pearl in the market is around Rs.300 to Rs 1500. Nowadays designer beads are being liked very much, which get a good price in the market. Much better money can be earned by exporting pearls in foreign markets than Indian market.\n" +
                        "\n" +
                        "ADVERTISEMENT\n" +
                        "\n" +
                        "After removing the pearl from the oyster, the oyster can also be sold in the market. Many decorative items are made of oysters. The work of extracting perfume oil from oysters in Kannauj is also done on a large scale. Due to which oysters can also be sold in the local market immediately. The water of rivers and ponds is also purified by oysters so that the problem of water pollution can be dealt with to a great extent.\n" +
                        "\n" +
                        "Where to take Training\n" +
                        "Training in pearl farming is done at Central Institute of Fresh Water Aquaculture, Bhubaneswar (Odisha). The institute imparts technical training on pearl production to rural youth, farmers, and students. Farmers Help also provides technical training on pearl production to farmers and students. This institution is running training programs in Hapur.",
            )
            db.collection("New Techniques").document("2").set(city)








            val intent = Intent(this@MainActivity, FarmerMainActivity::class.java)
            startActivity(intent)
            binding.textView.setTransitionVisibility(View.VISIBLE)
        }
        binding.buttonSignUpp.setOnClickListener() {




//            val storageRef = FirebaseStorage.getInstance().reference
//            val userImgProfile = storageRef.child("farmer_market_logo.png")
//            val inputStream = resources.openRawResource(R.drawable.farmer_market_logo)
//
//            // Upload the image data from the input stream
//            val uploadTask = userImgProfile.putStream(inputStream)



            val intent = Intent(this@MainActivity, SignUp::class.java)
            startActivity(intent)
        }


    }

}


