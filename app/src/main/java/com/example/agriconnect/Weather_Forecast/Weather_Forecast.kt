package com.example.agriconnect.Weather_Forecast

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agriconnect.databinding.FragmentWeatherForecastBinding


class Weather_Forecast : Fragment() {


    private var _binding: FragmentWeatherForecastBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

//        _binding = FragmentGovernmentSchemesBinding.inflate(inflater, container, false)
        _binding = FragmentWeatherForecastBinding.inflate(inflater,container,false)

//        MyViewMOdel.setData(binding.safsaf.text.toString())

//        MyViewMOdel.getData().observe(viewLifecycleOwner,{
//            binding.safsaf.setText(it)
//        })
//
//        binding.safsaf.setOnClickListener(){
//            Toast.makeText(this@Weather_Forecast.requireActivity(), "You clicked on item no. ", Toast.LENGTH_SHORT).show()
//
//        }
        return binding.root


       // return inflater.inflate(R.layout.fragment_weather__forecast, container, false)
    }




}