package com.example.agriconnect.Buying_Process

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.agriconnect.R


class Address_Confirmation_In_Buying_Process : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(
            R.layout.fragment_address__confirmation__in__buying__process,
            container,
            false
        )
    }

}