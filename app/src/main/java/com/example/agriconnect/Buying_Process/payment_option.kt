package com.example.agriconnect.Buying_Process

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentPaymentOptionBinding
import com.example.agriconnect.databinding.FragmentProductDetailsBinding


class payment_option : Fragment() {

    private var _binding: FragmentPaymentOptionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentPaymentOptionBinding.inflate(inflater,container,false)

        binding.radioButton2.setOnClickListener(){

            Toast.makeText(context,"Payment option not available",Toast.LENGTH_SHORT).show()
        }
        binding.radioButton3.setOnClickListener(){

            Toast.makeText(context,"Payment option not available",Toast.LENGTH_SHORT).show()
        }
        binding.radioButton4.setOnClickListener(){

            Toast.makeText(context,"Payment option not available",Toast.LENGTH_SHORT).show()
        }

        binding.radioButton1.setOnClickListener(){
            Toast.makeText(context,"Order Confirm",Toast.LENGTH_SHORT).show()

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Home::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }
        }

        return binding.root


    }



}