package com.example.agriconnect.Buying_Process

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentAddressConfirmationInBuyingProcessBinding
import com.example.agriconnect.databinding.FragmentProductDetailsBinding


class Address_Confirmation_In_Buying_Process : Fragment() {

    private var _binding: FragmentAddressConfirmationInBuyingProcessBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentAddressConfirmationInBuyingProcessBinding.inflate(inflater,container,false)

        binding.BuyNowButtonOnAddressPage.setOnClickListener(){


            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    payment_option::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }
        }

        return binding.root


    }

}