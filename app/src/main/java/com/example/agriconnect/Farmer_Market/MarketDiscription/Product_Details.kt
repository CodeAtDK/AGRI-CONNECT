package com.example.agriconnect.Farmer_Market.MarketDiscription

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.agriconnect.Buying_Process.Address_Confirmation_In_Buying_Process
import com.example.agriconnect.Farmer_Market.Farmer_Shop_ViewModel
import com.example.agriconnect.Farmer_Market.MarketPlace.Market_Place_Layout
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentProductDetailsBinding
import com.google.firebase.storage.FirebaseStorage


class Product_Details : Fragment() {

    private var _binding: FragmentProductDetailsBinding? = null
    private val binding get() = _binding!!

    private lateinit var ViewModel_Prodduct : Farmer_Shop_ViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_product__details, container, false)
        _binding = FragmentProductDetailsBinding.inflate(inflater,container,false)

        ViewModel_Prodduct = ViewModelProvider(requireActivity()).get(Farmer_Shop_ViewModel::class.java)

        ViewModel_Prodduct.getName().observe(viewLifecycleOwner) {
            binding.ProductMarketName.setText(it)
        }
        ViewModel_Prodduct.getDisc().observe(viewLifecycleOwner) {
            binding.ProductMarketDescription.setText(it)
        }
        ViewModel_Prodduct.getImg().observe(viewLifecycleOwner) {

            val storageReference = FirebaseStorage.getInstance().reference.child(it)

            storageReference.downloadUrl.addOnSuccessListener { uri ->
                val imageUrl = uri.toString()
                Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.government_schemes)
                    .error(R.drawable.new_farming_crops)
                    .into(binding.ProductMarketImage)
            }.addOnFailureListener { exception ->

                Toast.makeText(this@Product_Details.requireContext(), "Failed to load image", Toast.LENGTH_SHORT).show()
            }


        }
        ViewModel_Prodduct.getPrice().observe(viewLifecycleOwner) {
            val n = it.toString()
            binding.ProductPrice.setText("$"+n)
        }

        binding.BuyNow.setOnClickListener(){

            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container,
                    Address_Confirmation_In_Buying_Process::class.java,
                    null
                ) // Replace with your FragmentContainerView's ID and the new Fragment class
                addToBackStack(null)

            }

        }

        binding.RentTheProduct.setOnClickListener(){

            Toast.makeText(this@Product_Details.requireContext(), "Rent The Product Is Comming Soon", Toast.LENGTH_LONG).show()
        }
        binding.ADDToCart.setOnClickListener(){

            Toast.makeText(this@Product_Details.requireContext(),  "Cart Is Comming Soon", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }


}