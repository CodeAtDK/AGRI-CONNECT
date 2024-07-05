package com.example.agriconnect.Farmer_Market

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentFarmerShopBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore


class Farmer_Shop : Fragment() {

    private var _binding: FragmentFarmerShopBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Access a Cloud Firestore instance from your Activity

        _binding = FragmentFarmerShopBinding.inflate(inflater, container, false)
         return binding.root

    }


}