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

//            val city1 = CropReuridments_DataClass(
//                "Rice",
//                "Crop_Requridments/1.jpg",
//                "Total water requirement is 1100-1250",
//                " The daily consumptive use of rice varies from 6-10 mm and total water is ranges \n" +
//                        "from 1100 to 1250 mm depending upon the agro climatic situation.  Of the total water \n" +
//                        "required for the crop, 3% or 40 mm is used for the nursery, 16% or 200 mm for the land \n" +
//                        "preparation i.e. puddling and 81% or 1000 mm for field irrigation of the crop.\n" +
//                        " The daily consumptive use of rice varies from 6-10 mm and total water is ranges \n" +
//                        "from 1100 to 1250 mm depending upon the agro climatic situation.  Of the total water \n" +
//                        "required for the crop, 3% or 40 mm is used for the nursery, 16% or 200 mm for the land \n" +
//                        "preparation i.e. puddling and 81% or 1000 mm for field irrigation of the crop.\n",
//            )
//            val city2 = CropReuridments_DataClass(
//                "Groundnut",
//                "Crop_Requridments/2.jpg",
//                "Total water requirement 500-550 mm",
//                " Evapotranspiration is low during the first 35 days after sowing and last 35 days \n" +
//                        "before harvest and reaches a peak requirement between peg penetration and pod \n" +
//                        "development stages.  After the sowing irrigation the second irrigation can be scheduled \n" +
//                        "25 days after sowing i.e. 4 or 6 days after first hand hoeing and thereafter irrigation \n" +
//                        "interval of 15 days is maintained upto peak flowering.  During the critical stages the \n" +
//                        "interval may be 7 or 10 days depending upon the soil and climate.  During maturity \n" +
//                        "period the interval is 15 days.",
//            )
//            val city3 = CropReuridments_DataClass(
//                "Finger millet",
//                "Crop_Requridments/3.jpg",
//                "Total water requirement: 350 mm",
//                "Finger millet is a drought tolerant crop.  Pre-planting irrigation at 7 or 8 cm is \n" +
//                        "given.   \n" +
//                        "Third day after transplantation life irrigation with small quantity of water is \n" +
//                        "sufficient for uniform establishment.  Water is then withheld for 10-15 days after the \n" +
//                        "establishment of seedling for healthy and vigorous growth.  \n" +
//                        "Subsequently three \n" +
//                        "irrigations are essential at primordial initiation, flowering and grain filling stages.\n",
//            )
//            val city4 = CropReuridments_DataClass(
//                "Sugarcane",
//                "Crop_Requridments/4.jpg",
//                "Total water requirement: 1800-2200 mm",
//                "Formative phase (120 days from planting) is the critical period for water demand.  \n" +
//                        "To ensure uniform emergence and optimum number of tillers per unit area lesser quantity \n" +
//                        "of water at more frequencies is preferable.  The response for applied water is more during \n" +
//                        "this critical phase during which the crop needs higher quantity of water comparing, the \n" +
//                        "other two phases.  Water requirement, number of irrigations etc., are higher during this \n" +
//                        "period.  As there is no secondary thickening of stem, elongation of stem as sink for \n" +
//                        "storage of sugar it is desirable to maintain optimum level of moisture during grand \n" +
//                        "growth period.  Response for water is less in this stage and this will be still less in the \n" +
//                        "ripening stage.  During the ripening phase as harvest time approaches soil moisture \n" +
//                        "content should be allowed to decrease gradually so that growth of cane is checked and \n" +
//                        "sucrose content is increased.",
//            )
//            val city5 = CropReuridments_DataClass(
//                "Maize",
//                "Crop_Requridments/5.jpg",
//                " Total water requirement: 500 – 600 mm",
//                "The water requirement of maize is higher but it is very efficient in water use.  \n" +
//                        "Growth stages of maize crop are sowing, four leaf stage, knee high, grand growth, \n" +
//                        "tasseling, silking early dough and late dough stages.  Crop uniformly requires water in all \n" +
//                        "these stages.  Of this, tasseling, silking and early dough stages are critical periods.\n",
//            )
//            val city6 = CropReuridments_DataClass(
//                "Cotton",
//                "Crop_Requridments/6.jpg",
//                "Total water requirement: 550 – 600 mm",
//                "Cotton is sensitive to soil moisture conditions.  Little water is used by plant with \n" +
//                        "early part of the season and more water is lost through evaporation than transpiration.  As \n" +
//                        "the plant grows, the use of water increases from 3 mm / day reaching a peak of 10 mm a \n" +
//                        "day when the plant is loaded with flowers and boll.  Water used during the emergence and \n" +
//                        "early plant growth is only 10% of the total requirement.  Ample moisture during \n" +
//                        "flowering and boll development stages is essential.  In the early stage as well as at the end \n" +
//                        "the crop requires less water.  water requirement remains high till the boll development \n" +
//                        "stage.  If excess water is given in the stages other than critical stages it encourages the \n" +
//                        "vegetative growth because it is a indeterminate plant thereby boll setting may be \n" +
//                        "decreased.  Irrigation is continued until the first boll of the last flush opens, and then \n" +
//                        "irrigation is stopped.",
//            )
//            val city7 = CropReuridments_DataClass(
//                "Sorghum",
//                "Crop_Requridments/7.jpg",
//                " Total water requirement: 350-500 mm\n",
//                "The critical periods of water requirement are booting, flowering and dough  \n" +
//                        "stages.  The crop will be irrigated immediately after sowing.  Next irritation is given 15 \n" +
//                        "days sowing to encourage development of a strong secondary root system.  irrigation \n" +
//                        "prior to heading and ten days after heading are essential for successful crop production.\n",
//            )
//            val city8 = CropReuridments_DataClass(
//                "Pulses",
//                "Crop_Requridments/8.jpg",
//                " Total water requirement – 200-450 mm",
//                " Mostly the pulse are grown under rainfed condition.  Some pulse crops like \n" +
//                        "Redgram, Blackgram, Greengram are grown in summer season as irrigated crop which \n" +
//                        "need 3 to 4 irrigation at critical stags like germination, flowering and pod formation.\n",
//            )
//            val city9 = CropReuridments_DataClass(
//                "Wheat",
//                "Crop_Requridments/9.jpg",
//                "Total water requirement – 400 to 600 mm",
//                "Wheat Water Requirements\n" +
//                        "Wheat is a staple crop that requires careful water management to achieve optimal yields. Here are the key details regarding its water requirements:\n" +
//                        "\n" +
//                        "Water Requirement:\n" +
//                        "\n" +
//                        "Under favorable conditions, about 1000 cubic meters of water is needed to produce 1 ton of wheat.\n" +
//                        "\n" +
//                        "In less favorable conditions, this can increase to about 5000 cubic meters of water per ton.\n" +
//                        "\n" +
//                        "On average, the water requirement for wheat ranges from 400 to 600 mm during the growing season.\n" +
//                        "\n" +
//                        "Irrigation Methods:\n" +
//                        "\n" +
//                        "Surface Irrigation: Common methods include check basin and border methods.\n" +
//                        "\n" +
//                        "Sprinkler Irrigation: Useful when water supply is limited or the topography is not suited to surface irrigation.\n" +
//                        "\n" +
//                        "Water Management:\n" +
//                        "\n" +
//                        "Saline Conditions: Wheat can tolerate salinity levels up to 12 dS/m for 50% yield. In saline soils, furrow irrigation can help achieve better crop stands and yields.\n" +
//                        "\n" +
//                        "High Water Table: In areas with a high water table, fewer irrigations are needed. For example, one irrigation at the Crown Root Initiation (CRI) stage may be sufficient when the water table is between 100 and 110 cm.\n" +
//                        "\n" +
//                        "Critical Stages for Irrigation:\n" +
//                        "\n" +
//                        "Crown Root Initiation (CRI) Stage: Critical for establishing a good root system.\n" +
//                        "\n" +
//                        "Tillering Stage: Important for the development of tillers.\n" +
//                        "\n" +
//                        "Flowering Stage: Ensures proper grain filling and development.\n" +
//                        "\n" +
//                        "Grain Filling Stage: Crucial for achieving high grain yield and quality.",
//            )
//            val city10 = CropReuridments_DataClass(
//                "Bajra",
//                "Crop_Requridments/10.jpg",
//                "Total water requirement – 300-500 mm mm",
//                "Vegetative Stage: Moist weather and light to medium rainfall are beneficial.\n" +
//                        "\n" +
//                        "Flowering and Grain Development Stages: Clear and dry weather is ideal. Bajra cannot tolerate waterlogging1." +
//                        "Rainfed Cultivation: Bajra is often grown in rainfed conditions, relying on natural rainfall.\n" +
//                        "\n" +
//                        "Supplementary Irrigation: In areas with low rainfall, supplementary irrigation may be needed during critical growth stages." +
//                        "Moisture Conservation: Practices such as mulching and maintaining soil moisture can help conserve water.\n" +
//                        "\n" +
//                        "Efficient Irrigation: Techniques like drip irrigation can be used to provide water directly to the root zone, reducing wastage.",
//            )
//
//
//            db.collection("Crop Requirements").document("1").set(city1)
//            db.collection("Crop Requirements").document("2").set(city2)
//            db.collection("Crop Requirements").document("3").set(city3)
//            db.collection("Crop Requirements").document("4").set(city4)
//            db.collection("Crop Requirements").document("5").set(city5)
//            db.collection("Crop Requirements").document("6").set(city6)
//            db.collection("Crop Requirements").document("7").set(city7)
//            db.collection("Crop Requirements").document("8").set(city8)
//            db.collection("Crop Requirements").document("9").set(city9)
//            db.collection("Crop Requirements").document("10").set(city10)

            val intent = Intent(this@MainActivity, FarmerMainActivity::class.java)
            startActivity(intent)

        }


    }



}


