package com.example.agriconnect.GovernmentSchemes.GovernmentSchemeDiscripition

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.GovernmentSchemes.Government_Schemes
import com.example.agriconnect.GovernmentSchemes.Government_Schemes_View_Model
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentGovernmentSchemeDiscriptionBinding


class Government_Scheme_Discription : Fragment() {

    private var _binding: FragmentGovernmentSchemeDiscriptionBinding? = null
    private val binding get() = _binding!!


    private lateinit var MyViewModel: Government_Schemes_View_Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_government__scheme__discription, container, false)
        _binding = FragmentGovernmentSchemeDiscriptionBinding.inflate(inflater, container, false)

        MyViewModel = ViewModelProvider(requireActivity()).get(Government_Schemes_View_Model::class.java)

        MyViewModel.getData1().observe(viewLifecycleOwner){
            binding.GovernmentSchemeDiscriptionName.setText(it)
        }
        MyViewModel.getData2().observe(viewLifecycleOwner){
            binding.GovernmentSchemeDiscriptionDiscription.setText(it)
        }
        MyViewModel.getData3().observe(viewLifecycleOwner){
            binding.GovernmentSchemeBenefits.setText(it)
        }
        MyViewModel.getData4().observe(viewLifecycleOwner) {
            binding.GovenmentSchemeEligibility.setText(it)
        }
        MyViewModel.getData5().observe(viewLifecycleOwner){
            binding.GovernmentSchemeDocumentsRequired.setText(it)
        }
        MyViewModel.getData6().observe(viewLifecycleOwner){
            binding.link.setText(it)

        }





            binding.GovernmentSchemeApplyNowButton.setOnClickListener {

//            val url = MyViewModel.getData6().value
                val url = binding.link.text.toString()
                Toast.makeText(requireContext(), url, Toast.LENGTH_SHORT).show()
                Log.d("URL", url.toString())
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                startActivity(intent)
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
                    setReorderingAllowed(true)
                    replace(
                        R.id.fragment_container,
                        Government_Schemes::class.java,
                        null
                    ) // Replace with your FragmentContainerView's ID and the new Fragment class
                    addToBackStack(null)

                }





            }
        })
    }

}