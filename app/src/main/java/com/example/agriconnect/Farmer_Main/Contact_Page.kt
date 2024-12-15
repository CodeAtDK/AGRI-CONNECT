package com.example.agriconnect.Farmer_Main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentChatBotBinding
import com.example.agriconnect.databinding.FragmentContactPageBinding

class Contact_Page : Fragment() {

    private var _binding: FragmentContactPageBinding?= null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentContactPageBinding.inflate(inflater,container,false)
//        return inflater.inflate(R.layout.fragment_contact__page, container, false)


        binding.linkdin.setOnClickListener {

//            val url = MyViewModel.getData6().value
            val url = "https://www.linkedin.com/"
            Toast.makeText(requireContext(), url, Toast.LENGTH_SHORT).show()
            Log.d("URL", url)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.instagram.setOnClickListener {

//            val url = MyViewModel.getData6().value
            val url = "https://www.instagram.com/?hl=en"
            Toast.makeText(requireContext(), url, Toast.LENGTH_SHORT).show()
            Log.d("URL", url)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        binding.facebook.setOnClickListener {

//            val url = MyViewModel.getData6().value
            val url = "https://www.facebook.com/"
            Toast.makeText(requireContext(), url, Toast.LENGTH_SHORT).show()
            Log.d("URL", url)
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        return binding.root
    }

}