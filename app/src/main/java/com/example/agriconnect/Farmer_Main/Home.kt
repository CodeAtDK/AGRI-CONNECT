package com.example.agriconnect.Farmer_Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.agriconnect.Crop_Suggestion.Crop_Suggestion
import com.example.agriconnect.Farmer_Market.Farmer_Shop
import com.example.agriconnect.GovernmentSchemes.Government_Schemes
import com.example.agriconnect.New_Crop.New_farming_Crops
import com.example.agriconnect.New_Techniques.New_Farming_Teachniques
import com.example.agriconnect.R
import com.example.agriconnect.Weather_Forecast.Weather_Forecast
import com.example.agriconnect.databinding.FragmentHomeBinding


class Home : Fragment() {

    private  var _binding: FragmentHomeBinding?= null
    private val binding get() = _binding!!

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
                addToBackStack(null)

            }
        }
        binding.weatherForecastCard.setOnClickListener() {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Weather_Forecast::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }
        }
        binding.cropSuggestionCard.setOnClickListener() {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Crop_Suggestion::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }
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

        return binding.root


    }
}