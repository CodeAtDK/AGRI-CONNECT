package com.example.agriconnect.New_Crop.New_Crops_Discription

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.agriconnect.New_Crop.New_Crops_View_Model
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentNewCropsDiscriptionsBinding
import com.google.firebase.storage.FirebaseStorage


class New_Crops_Discriptions : Fragment() {

    private var _binding: FragmentNewCropsDiscriptionsBinding? = null
    private val binding get() = _binding!!

    private lateinit var MyViewModel: New_Crops_View_Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new__crops__discriptions, container, false)
        _binding = FragmentNewCropsDiscriptionsBinding.inflate(inflater, container, false)

        MyViewModel = ViewModelProvider(requireActivity()).get(New_Crops_View_Model::class.java)

        MyViewModel.getData1().observe(viewLifecycleOwner) {
            binding.NewCropsName.setText(it)
        }
        MyViewModel.getData3().observe(viewLifecycleOwner) {

            val storageReference = FirebaseStorage.getInstance().reference.child(it)

            storageReference.downloadUrl.addOnSuccessListener { uri ->
                val imageUrl = uri.toString()
                Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.government_schemes)
                    .error(R.drawable.new_farming_crops)
                    .into(binding.NewCropsDescriptionImage)
            }.addOnFailureListener { exception ->

                Toast.makeText(this@New_Crops_Discriptions.requireContext(), "Failed to load image", Toast.LENGTH_SHORT).show()
            }


        }
        MyViewModel.getData4().observe(viewLifecycleOwner) {
            binding.NewCropsDetails.setText(it)
        }
        MyViewModel.getData5().observe(viewLifecycleOwner){
            binding.HowToGrowTheCrop.setText(it)
        }

        MyViewModel.getData7().observe(viewLifecycleOwner){
            binding.EquimentsRequirement.setText(it)
        }





        return binding.root
    }

}