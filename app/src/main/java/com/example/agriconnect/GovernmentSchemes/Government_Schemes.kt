package com.example.agriconnect.GovernmentSchemes

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agriconnect.Farmer_Main.Home
import com.example.agriconnect.GovernmentSchemes.GovernmentSchemeDiscripition.Government_Scheme_Discription
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentGovernmentSchemesBinding
import com.google.android.material.color.utilities.Scheme
import com.google.firebase.Firebase
import com.google.firebase.firestore.AggregateQuery
import com.google.firebase.firestore.AggregateSource
import com.google.firebase.firestore.firestore


class Government_Schemes : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterforGovernmentSchemes
    private lateinit var dataList: ArrayList<GovernmentSchemes>

    private lateinit var Government_Schemes_View_Model1: Government_Schemes_View_Model

    lateinit var schemename: Array<String>
    lateinit var schemeDiscription: Array<String>
    lateinit var schemesBenefits: Array<String>
    lateinit var schemesEligibility: Array<String>
    lateinit var DocumentsRequired: Array<String>
    lateinit var SchemeLink: Array<String>
    //lateinit var Img: Array<Int>


    val db = Firebase.firestore
    private  var _binding: FragmentGovernmentSchemesBinding?= null
    private val binding get() = _binding!!




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{

        // Inflate the layout for this fragment

        Government_Schemes_View_Model1 = ViewModelProvider(requireActivity()).get(
            Government_Schemes_View_Model::class.java)

        _binding = FragmentGovernmentSchemesBinding.inflate(inflater, container, false)

//        Government_Schemes_View_Model = ViewModelProvider(requireActivity()).get(Government_Schemes_View_Model::class.java)



         return binding.root

    }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


       dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView_government_Scheme)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        // dataList = arrayListOf<GovernmentSchemes>()
//        recyclerView.adapter = AdapterforGovernmentSchemes(dataList)
        adapter = AdapterforGovernmentSchemes(dataList)
        recyclerView.adapter = adapter

       adapter.setOnItemClickListener(object : AdapterforGovernmentSchemes.onItemClickListener {
           override fun onItemClick(position: Int) {

                Log.d("TAG", "onItemClick: $position")
               Toast.makeText(this@Government_Schemes.requireActivity(), "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
           }

       })



   }








    private fun dataInitialize(){

        dataList = arrayListOf<GovernmentSchemes>()

//        Img = arrayOf(
//            R.drawable.icons_name,
//            R.drawable.baseline_account_circle_24,
//            R.drawable.baseline_home_24,
//        )

//        val docRef = db.collection("cities").document("BJ")
//        docRef.get().addOnSuccessListener { documentSnapshot ->
//            val city = documentSnapshot.toObject<City>()

        var count : Int = 0

        val collectionRef = db.collection("GovernmentSchemes")

        collectionRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                count = task.result?.size() ?: 0
                println("Total documents: $count")
            Log.d("Tag","$count")
                adds(count)
            } else {
                println("Error fetching documents: ${task.exception}")
            }
        }

        var b = "hi i a,"
        schemename = arrayOf(


            )
        schemeDiscription = arrayOf(

        )
        schemesBenefits = arrayOf(


        )
        schemesEligibility = arrayOf(


        )
        DocumentsRequired = arrayOf(


        )
        SchemeLink = arrayOf(

        )
//
//
//
        for (i in schemename.indices){

            val dataClass = GovernmentSchemes(schemename[i],schemeDiscription[i])
            dataList.add(dataClass)
        }

    }

    private fun adds(count: Int) {

        var a :Int= 1;

        var n = ""
        while(a < count+1) {
            val docRef = db.collection("GovernmentSchemes").document("${a}")
            docRef.get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val data =
                        documentSnapshot.toObject<GovernmentSchemes>(GovernmentSchemes::class.java)
                    // Access data fields (e.g., val item = data["item"])

                    if (data != null) {
                        Log.d("TAG", "DocumentSnapshot data: ${data.SchemesName}")

                        schemename = schemename + data.SchemesName.toString()
                        schemeDiscription = schemeDiscription + data.SchemesDiscription.toString()
                        schemesBenefits = schemesBenefits + data.SchemesBenefits.toString()
                        schemesEligibility = schemesEligibility + data.SchemesEligibility.toString()
                        DocumentsRequired = DocumentsRequired + data.SchemesDocumentRequired.toString()
                        SchemeLink = SchemeLink + data.SchemesLink.toString()

                        val dataclass = GovernmentSchemes(data.SchemesName,data.SchemesDiscription,data.SchemesBenefits,data.SchemesEligibility,data.SchemesDocumentRequired,data.SchemesLink)
                        dataList.add(dataclass)

                        // add1(data.SchemesName,data.SchemesDiscription)
                        add1(dataList)

                        n = "Done"
                        a = a + 1
                    } else {
                        // Document does not exist
                        Log.d("TAG", "DocumentSnapshot does not exist")
                        a = 0
                    }


                }
                else{
                    Log.d("Tag" , "Failed")
                    a = 0
                }




            }.addOnFailureListener{
                a = 0
            }

            a = a+1



            Log.d("TAG", "dataInitialize: $a")

            if(a == 7){
                //add1(dataList)
            }
        }

    }

    fun add1(datalist1: ArrayList<GovernmentSchemes> ) {

        Log.d("TAG", "add1: $datalist1")
        adapter = AdapterforGovernmentSchemes(datalist1)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : AdapterforGovernmentSchemes.onItemClickListener {

            override fun onItemClick(position: Int) {

                Log.d("TAG", "onItemClick: $position")
                //Toast.makeText(this@Government_Schemes.requireActivity(), "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
                //val transition: FragmentTransaction = childFragmentManager.beginTransaction()
                //.replace(R.id.fragment_container, FragmentHomeBinding)
              //  transition.commit()
//                val homeFragment = Home()
//                transition.replace(R.id.fragment_container, homeFragment)
//                transition.commit()

//                FarmerMainActivity.replaceFragment(Home())Home

                Government_Schemes_View_Model1.setData1(dataList[position].SchemesName)
                Government_Schemes_View_Model1.setData2(dataList[position].SchemesDiscription)
                Government_Schemes_View_Model1.setData3(dataList[position].SchemesBenefits)
                Government_Schemes_View_Model1.setData4(dataList[position].SchemesEligibility)
                Government_Schemes_View_Model1.setData5(dataList[position].SchemesDocumentRequired)
                Government_Schemes_View_Model1.setData6(dataList[position].SchemesLink)

                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(
                        R.id.fragment_container,
                        Government_Scheme_Discription::class.java,
                        null
                    ) // Replace with your FragmentContainerView's ID and the new Fragment class
                    addToBackStack(null)

                }
            }


        })


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
                        Home::class.java,
                        null
                    ) // Replace with your FragmentContainerView's ID and the new Fragment class
                    addToBackStack(null)

                }

            }
        })
    }


}