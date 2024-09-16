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
import com.example.agriconnect.Farmer_Main.FarmerMainActivity
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.Farmer_Market.FarmerProduct
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



//            val city = New_Techniques_Data_Class(
//                "New_Techniques/Drone_Farming.jpeg",
//                "Drone Farming",
//                "An agricultural drone is an unmanned aerial vehicle used in agriculture operations, mostly in yield optimization and in monitoring crop growth and crop production. Agricultural drones provide information on crop growth stages, crop health, and soil variations. Multispectral sensors are used on agricultural drones to image electromagnetic radiation beyond the visible spectrum, including near-infrared and short-wave infrared.",
//                        "1. Crop Monitoring\n" +
//                        "High-resolution images and data on plant health, water levels, and pest infestations1.\n" +
//                        "\n" +
//                        "2. Precision Farming\n" +
//                        "Targeted application of fertilizers, pesticides, and herbicides1.\n" +
//                        "\n" +
//                        "3. Surveying and Mapping\n " +
//                        "Creating accurate maps of your farm to identify areas needing attention1.\n" +
//                        "\n" +
//                        "4. Livestock Monitoring\n " +
//                        "Keeping track of animal health and location1.",
//                "1. Choose the Right Drone\n" +
//                        "Select a drone that suits your needs. For example, the DJI MG-1S is popular for spraying pesticides and fertilizers2.\n" +
//                        "\n" +
//                        "2. Learn to Operate the Drone\n" +
//                        "Training: Take a course or watch tutorials on how to assemble and operate agricultural drones\n" +
//                        "\n" +
//                        "3. Regulations\n" +
//                        "Ensure you comply with local regulations regarding drone usage.\n" +
//                        "\n" +
//                        "4. Plan Your Flights\n" +
//                        "* Mapping: Use software to plan flight paths and ensure comprehensive coverage of your fields.\n" +
//                        "* Data Collection: Regularly fly the drone to collect data and monitor crop health.\n" +
//                        "\n" +
//                        "5. Analyze Data and Take Action\n" +
//                        "* Data Analysis: Use software to analyze the data collected by the drone.\n" +
//                        "* Decision Making: Make informed decisions based on the data to optimize crop yields and manage resources efficiently1.\n" +
//                        "\n" +
//                        "6. Maintenance and Updates\n" +
//                        "* Regular Maintenance: Keep your drone in good condition with regular checks and maintenance.\n" +
//                        "* Software Updates: Ensure your software is up-to-date for the latest features and improvements.",
//                "1. Drone with Camera and Sensors: For capturing images and data.\n" +
//                        "2. Spray System: If you plan to use the drone for applying chemicals.\n" +
//                        "3. Software: For data analysis and flight planning.",
//                "",
//            )

//            val city = New_Farming_Crop_Data_Class(
//                "New_Crops/Pearl Farming.jpeg",
//                "Pearl Farming",
//                "Pearls have great demand in national and export markets. You can easily pursue pearl farming subsequently with fish farming and other commercial aquaculture activities.\n" +
//                        "Talking about pearl farming profit, you can expect to earn 50-60% from what you invest. Furthermore, if you acquire the right pearl farming training and tools, you can expect to earn even 100% profit — but that’s a long road.",
//                "1. Site Selection & Setting Pearl Farm\n" +
//                        "You have to select the site and get its water approved by government-approved laboratories. CIFA-approved laboratories are ideal as they are genuine and reliable. Their test will help you decide whether the water quality is good for pearl farming or not.\n" +
//                        "\n" +
//                        "2. Obtaining Pearl Oyster Stock\n" +
//                        "After site selection, it’s important to obtain the oyster stock through the following methods:\n" +
//                        "\n" +
//                        "Spat Collection \n" +
//                        "In this method, you can collect the young swimming oyster larvae called spat. These larvae are in a perfect state for grafting and can be easily attached to any surface.\n" +
//                        "\n" +
//                        "Hatchery Production\n" +
//                        "You can also refer to hatchery-produced spat if they are available in your area and are reasonably priced.\n" +
//                        "\n" +
//                        "Collect Adult Oysters\n" +
//                        "You can collect adult oysters that are available at reasonable prices. However, they have more mortality risk.\n" +
//                        "\n" +
//                        "3. Drill & Hang Oysters\n" +
//                        "Drill and Hang Oysters\n" +
//                        "\n" +
//                        "Once you have acquired the stock of oysters, keep them in the approved water site. You can hang them in chaplets, which are similar to circlets or garlands. You can place them in big net containers. \n" +
//                        "\n" +
//                        "4. Grafting\n" +
//                        "You can use the artificial method of grafting to develop pearls. You can plant an artificial nucleus in a pearl oyster’s tissue that will develop into a pearl.\n" +
//                        "\n" +
//                        "5. Pearl Development Process\n" +
//                        "Once you implant the nucleus, it irritates the oyster. And as a result, the oyster covers itself with a calcium carbonate layer. It will take 12-24 months for pearls to develop. During this transition, take proper care, feed them timely, and prevent them from any kind of infection. \n" +
//                        "\n" +
//                        "6. Marketing of Pearls\n" +
//                        "Once you have pearls produced, ensure you market them to the right market. You can endorse them to jewellery, cosmetics, and garment brands. Have a marketing strategy in place. And if you have a good quality stock of pearls, you won’t have to bid hard to trade them in the market. Their quality will speak for themselves. ",
//
//                "1. Infrastructure:\n" +
//                        "* Ponds or Cages: Depending on whether you’re doing freshwater or saltwater farming, you’ll need ponds or cages to house the oysters1.\n" +
//                        "* Rafts and Longlines: For saltwater farming, rafts and longlines are used to suspend the oysters in the water2.\n" +
//                        "\n" +
//                        "2. Water Quality Management:\n" +
//                        "* Water Testing Kits: To regularly check the water quality, including pH, salinity, and temperature3.\n" +
//                        "* Aerators: To ensure proper oxygen levels in the water\n" +
//                        "\n" +
//                        "3. Oyster Handling Equipment:\n" +
//                        "*Nets and Baskets: For collecting and handling oysters2.\n" +
//                        "*Nylon Bags: Used to hold oysters during the initial stages after nucleation1.\n" +
//                        "\n" +
//                        "4. Nucleation and Grafting Tools:\n" +
//                        "*Surgical Instruments: Precision tools for the delicate process of inserting nuclei into oysters3.\n" +
//                        "*Nuclei: Small beads or pieces of tissue used to stimulate pearl formation1.\n" +
//                        "\n" +
//                        "5. Feeding and Maintenance:\n" +
//                        "* Feeding Systems: Automated or manual systems to feed the oysters3.\n" +
//                        "* Cleaning Equipment: Brushes and other tools to clean the oysters and their environment1.\n" +
//                        "\n" +
//                        "6. Harvesting and Processing:\n" +
//                        "* Harvesting Tools: Equipment for safely removing pearls from oysters2.\n" +
//                        "* Sorting and Grading Tools: Tools to sort and grade pearls based on size, shape, and luster3.\n" +
//                        "\n" +
//                        "7. Safety and Miscellaneous:\n" +
//                        "* Protective Gear: Gloves, masks, and other protective gear for handling oysters and chemicals1.\n" +
//                        "* Storage Containers: For storing harvested pearls and equipment",
//            )

//            val city = FarmerProduct(
//                "Farmer_Products/71jUyhTDoWL._SL1376_.jpg",
//                "WHITE COTTON/GOSSYPIUM SEED-100 GM (350 Seeds Per Packet)",
//                575,
//                "100g",
//                "1. WHITE COTTON/GOSSYPIUM SEED While cotton (Gossypium) has been around for a long time and grown mainly for its fibers, cotton growing can be a fun learning experience. Not only will get a chance to learn some cotton plant info, but they will love the fluffy, white product of all their labor. You can take the lesson further by exploring how your harvested cotton gets processed to make the clothes we wear.\n" +
//                        "2. HOW TO GROW:Fill the container with the potting mix, leaving a space of about two inches or so from the top. Place about three cotton seeds on top of the soil and then cover with another inch or so of potting mix. Place in sunlight and keep moist, adding water as needed so the upper portion of soil does not get too dry.You should begin to see sprouts within 7-10 days.\n" +
//                        "3. Once the seedlings have sprouted, you can thoroughly water the plants each week as part of your cotton plant care.Then you may transplant the seedlings to various pots or desired areas\n" +
//                        "4. Popular plant Seed *Easily Grown *Quality Seeds\n" +
//                        "5. All pictures shown are for illustration purpose only.",
//                null,
//            )

//            val city = FarmerProduct(
//                "Farmer_Products/JhonDeereW-70.avif",
//                "W-70 Synchrosmart combine harvester Powerpro",
//                2750000,
//                "10",
//                "John Deere W-70 Synchrosmart Combine Harvester Powerpro is a powerful, yet light weight 100HP compact harvester! It is swift and can work efficiently in wet and small fields. Due to its ergonomic dimensions it can easily enter where other harvesters cannot.\n" +
//                        "Compact design helps in crossing through narrow lanes\n" +
//                        "Saves fuel due to light wight and offers high productivity\n" +
//                        "Suitable for harvesting of  Paddy, Wheat, Corn, Soyabean, Mustard, chickpea, Millets, Pulses, Sunflower,Safflower, Flaxseed",
//                123,
//
//            )
////            db.collection("Seed MarketFarmer_Market").document("1").set(city)
////            db.collection("Seed MarketFarmer_Market").document("2").set(city)
//            Toast.makeText(this, "Data Added", Toast.LENGTH_SHORT).show()
//
//
//            db.collection("Equipments MarketFarmer_Market").document("1").set(city)
//            db.collection("Equipments MarketFarmer_Market").document("2").set(city)
//            db.collection("Seed MarketFarmer_Market").document("2").set(city1)







            // Intent is use to change the activity

            val intent = Intent(this@MainActivity, SignIn::class.java)
            startActivity(intent)
            binding.textView.setTransitionVisibility(View.VISIBLE)
        }

        // This button will change the activity from main to SignUp
        binding.buttonSignUpp.setOnClickListener() {




//            val storageRef = FirebaseStorage.getInstance().reference
//            val userImgProfile = storageRef.child("farmer_market_logo.png")
//            val inputStream = resources.openRawResource(R.drawable.farmer_market_logo)
//
//            // Upload the image data from the input stream
//            val uploadTask = userImgProfile.putStream(inputStream)


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


