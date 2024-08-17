package com.example.agriconnect.Farmer_Market

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.agriconnect.Farmer_Market.MarketPlace.Market_Place_Layout
import com.example.agriconnect.GovernmentSchemes.GovernmentSchemeDiscripition.Government_Scheme_Discription
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentFarmerShopBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore


class Farmer_Shop : Fragment() {

    private var _binding: FragmentFarmerShopBinding? = null
    private val binding get() = _binding!!

    private lateinit var MyViewModel: Farmer_Shop_ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Access a Cloud Firestore instance from your Activity

        _binding = FragmentFarmerShopBinding.inflate(inflater, container, false)


        MyViewModel = ViewModelProvider(requireActivity()).get(Farmer_Shop_ViewModel::class.java)

        binding.EquipmentMarket.setOnClickListener {

            MyViewModel.setData("Equipments Market")


            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Market_Place_Layout::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }


        }
        binding.SeedsFarmer.setOnClickListener {

            MyViewModel.setData("Seed Market")


            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Market_Place_Layout::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }

        }

         return binding.root

    }


}