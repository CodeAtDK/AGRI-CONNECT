package com.example.agriconnect.Farmer_Main

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.app.ActivityCompat.finishAffinity
import androidx.fragment.app.commit
import com.example.agriconnect.Crop_Suggestion.Crop_Suggestion
import com.example.agriconnect.Farmer_Market.Farmer_Shop
import com.example.agriconnect.GovernmentSchemes.Government_Schemes
import com.example.agriconnect.New_Crop.New_farming_Crops
import com.example.agriconnect.New_Techniques.New_Farming_Teachniques
import com.example.agriconnect.R
import com.example.agriconnect.Weather_Forecast.Weather_Forecast
import com.example.agriconnect.databinding.FragmentHomeBinding
import kotlin.system.exitProcess



class Home : Fragment(){
    interface OnAppExitListener {

        fun onAppExit()

    }

    private  var _binding: FragmentHomeBinding?= null
    private val binding get() = _binding!!

    private var exitlistener: OnAppExitListener? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnAppExitListener) {
            exitlistener = context
        } else {
            throw RuntimeException("$context must implement OnAppExitListener")
        }
    }
    override fun onDetach() {
        super.onDetach()
        exitlistener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        //var View = inflater.inflate(R.layout.fragment_home, container, false)

//        _binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.ShopCard.setOnClickListener() {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Farmer_Shop::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack("Tag1")

            }
        }
        binding.weatherForecastCard.setOnClickListener() {
//            parentFragmentManager.commit {
//                setReorderingAllowed(true)
//                replace(
//                    R.id.fragment_container,
//                    Weather_Forecast::class.java,
//                    null
//                ) // Replace with your FragmentContainerView's ID and the new Fragment class
//                addToBackStack(null)
//
//            }
            Toast.makeText(this@Home.requireActivity(),"The Weather Forecasting will be avilable Soon....",Toast.LENGTH_SHORT).show()
        }
        binding.cropSuggestionCard.setOnClickListener() {
//            parentFragmentManager.commit {
//                setReorderingAllowed(true)
//                replace(
//                    R.id.fragment_container,
//                    Crop_Suggestion::class.java,
//                    null
//                ) // Replace with your FragmentContainerView's ID and the new Fragment class
//                addToBackStack(null)
//
//            }
            Toast.makeText(this@Home.requireActivity(),"Crop Requiredments will be available Soon....",Toast.LENGTH_SHORT).show()
        }
        binding.governmentSchemesCard.setOnClickListener() {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Government_Schemes::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }
        }
        binding.newFarmingCropsCard.setOnClickListener() {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    New_farming_Crops::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }
        }
        binding.newFarmingTechniqueCard.setOnClickListener() {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    New_Farming_Teachniques::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }
        }

        binding.StopExit.setOnClickListener(){

            binding.cardViewExitapp.setVisibility(INVISIBLE)
        }

        binding.ButtonExit.setOnClickListener(){

            exitlistener?.onAppExit()


        }

        return binding.root


    }

//    override fun onBackPressed(){
//
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){

            override fun handleOnBackPressed() {

                binding.cardViewExitapp.setVisibility(VISIBLE)

            }
        })

    }






}