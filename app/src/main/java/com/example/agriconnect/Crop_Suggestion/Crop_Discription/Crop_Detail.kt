package com.example.agriconnect.Crop_Suggestion.Crop_Discription

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.agriconnect.Crop_Suggestion.Crop_Requriments_View_Model
import com.example.agriconnect.Crop_Suggestion.Crop_Suggestion
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.GovernmentSchemes.AdapterforGovernmentSchemes
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentCropDetailBinding
import com.example.agriconnect.databinding.FragmentCropSuggestionBinding
import com.google.firebase.storage.FirebaseStorage


class Crop_Detail : Fragment() {

    private var _binding : FragmentCropDetailBinding? = null
            private val binding get() = _binding!!

    private lateinit var MyViewModele_Crop : Crop_Requriments_View_Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCropDetailBinding.inflate(inflater,container,false)

        MyViewModele_Crop = ViewModelProvider(requireActivity()).get(Crop_Requriments_View_Model::class.java)

        MyViewModele_Crop.getData().observe(viewLifecycleOwner){

            binding.CropName.setText(it)
        }
        MyViewModele_Crop.getData2().observe(viewLifecycleOwner){
            binding.CropWaterLevel.setText(it)
        }
        MyViewModele_Crop.getData3().observe(viewLifecycleOwner){
            binding.CropDetail.setText(it)
        }
        MyViewModele_Crop.getData1().observe(viewLifecycleOwner) {

            val storageReference = FirebaseStorage.getInstance().reference.child(it)

            storageReference.downloadUrl.addOnSuccessListener { uri ->
                val imageUrl = uri.toString()
                Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.loding)
                    .error(R.drawable.error)
                    .into(binding.CropImage)
            }.addOnFailureListener { exception ->

                Toast.makeText(this@Crop_Detail.requireContext(), "Failed to load image", Toast.LENGTH_SHORT).show()
            }


        }


        return binding.root
        //return inflater.inflate(R.layout.fragment_crop__detail, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity().onBackPressedDispatcher.addCallback(this,object : OnBackPressedCallback(true){

            override fun handleOnBackPressed() {

//                if(parentFragmentManager.findFragmentById(R.id.fragment_container) is Home) {
                Log.d("Tag","${parentFragmentManager.findFragmentById(R.id.fragment_container)}")
//
//
//                }

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
        })
    }

}