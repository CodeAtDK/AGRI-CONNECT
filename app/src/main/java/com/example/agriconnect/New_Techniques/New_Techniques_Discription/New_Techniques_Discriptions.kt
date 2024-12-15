package com.example.agriconnect.New_Techniques.New_Techniques_Discription

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
import com.example.agriconnect.Crop_Suggestion.Crop_Suggestion
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.New_Crop.New_Crops_View_Model
import com.example.agriconnect.New_Techniques.Adapter_New_Farming_Teachniques
import com.example.agriconnect.New_Techniques.New_Farming_Teachniques
import com.example.agriconnect.New_Techniques.New_Techniques_View_Model
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentNewTechniquesDiscriptionsBinding
import com.google.firebase.storage.FirebaseStorage


class New_Techniques_Discriptions : Fragment() {

    private var _binding : FragmentNewTechniquesDiscriptionsBinding? = null
    private val binding get() = _binding!!

    private lateinit var MyViewModel_Techniques : New_Techniques_View_Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_new__techniques__discriptions, container, false)

        _binding = FragmentNewTechniquesDiscriptionsBinding.inflate(inflater, container, false)

        MyViewModel_Techniques = ViewModelProvider(requireActivity()).get(New_Techniques_View_Model::class.java)


        MyViewModel_Techniques.getData1().observe(viewLifecycleOwner) {
            binding.NewTechniqueName.setText(it)
        }

        MyViewModel_Techniques.getData3().observe(viewLifecycleOwner) {

            val storageReference = FirebaseStorage.getInstance().reference.child(it)

            storageReference.downloadUrl.addOnSuccessListener { uri ->
                val imageUrl = uri.toString()
                Glide.with(this)
                    .load(imageUrl)
                    .placeholder(R.drawable.loding)
                    .error(R.drawable.error)
                    .into(binding.NewTechniqueDescriptionImage)
            }.addOnFailureListener { exception ->

                Toast.makeText(this@New_Techniques_Discriptions.requireContext(), "Failed to load image", Toast.LENGTH_SHORT).show()
            }


        }
        MyViewModel_Techniques.getData4().observe(viewLifecycleOwner) {
            binding.NewTechniqueDetails.setText(it)
        }
        MyViewModel_Techniques.getData5().observe(viewLifecycleOwner){
            binding.ListOfBenfits.setText(it)
        }
        MyViewModel_Techniques.getData6().observe(viewLifecycleOwner){
            binding.ImplementationInDetails.setText(it)
        }
        MyViewModel_Techniques.getData7().observe(viewLifecycleOwner){
            binding.RequiredEquipments.setText(it)
        }


        return binding.root
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

                    Log.d("Tag2","${parentFragmentManager.findFragmentById(R.id.fragment_container)}")


                    setReorderingAllowed(true)
                    replace(
                        R.id.fragment_container,
                        New_Farming_Teachniques::class.java,
                        null
                    ) // Replace with your FragmentContainerView's ID and the new Fragment class
                    addToBackStack(null)

                }





            }
        })
    }

}