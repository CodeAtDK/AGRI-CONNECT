package com.example.agriconnect.GovernmentSchemes.GovernmentSchemeDiscripition

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.agriconnect.GovernmentSchemes.Government_Schemes_View_Model
import com.example.agriconnect.databinding.FragmentGovernmentSchemeDiscriptionBinding


class Government_Scheme_Discription : Fragment() {

    private var _binding: FragmentGovernmentSchemeDiscriptionBinding? = null
    private val binding get() = _binding!!


    private lateinit var MyViewModel: Government_Schemes_View_Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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

        binding.GovernmentSchemeDiscriptionDetail.setText("Pradhan Mantri Mudra Yojana (PMMY) is a flagship scheme of Government of India. The scheme facilitates micro credit/Loan up to Rs. 10 lakhs to income generating micro enterprises engaged in the non farm sector in manufacturing, trading or service sectors including activities allied to agriculture such as poultry, dairy, beekeeping, etc. The Scheme provides financial assistance extended by Member Lending Institutions to the non-corporate, non-farm sector income generating activities of micro and small entities.\n" +
                "\n" +
                "These micro and small entities comprise of millions of proprietorship / partnership firms running as small manufacturing units, service sector units, shopkeepers, fruits / vegetable vendors, truck operators, food-service units, repair shops, machine operators, small industries, artisans, food processors and others. \n" +
                "\n" +
                "The loans under Pradhan Mantri Mudra Yojana can be availed through eligible Member Lending Institutions (MLIs),  which include:\n" +
                "Public Sector BanksPrivate Sector BanksState operated cooperative banksRural banks from regional sectorMicro Finance Institution (MFI)Non-Banking Finance Company (NBFC)Small Finance Banks (SFBs) Other financial intermediary approved by Mudra Ltd. as member financial institutions\n" +
                "Interest rate\n" +
                "The interest rates are declared by Member  Lending Institutions from time to time as per Reserve Bank of India guidelines based on which applicable interest rate is  determined.\n" +
                "\n" +
                "Upfront fee/Processing charges\n")






        return binding.root
    }

}