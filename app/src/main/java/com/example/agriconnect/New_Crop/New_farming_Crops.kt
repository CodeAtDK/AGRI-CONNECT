package com.example.agriconnect.New_Crop

import android.media.audiofx.DynamicsProcessing.Eq
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agriconnect.GovernmentSchemes.AdapterforGovernmentSchemes
import com.example.agriconnect.GovernmentSchemes.GovernmentSchemeDiscripition.Government_Scheme_Discription
import com.example.agriconnect.GovernmentSchemes.GovernmentSchemes
import com.example.agriconnect.New_Crop.New_Crops_Discription.New_Crops_Discriptions
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentNewFarmingCropsBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class New_farming_Crops : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter_For_New_Crops
    private lateinit var dataList: ArrayList<New_Farming_Crop_Data_Class>

    lateinit var New_Crop_name: Array<String>
    lateinit var New_Crop_Image: Array<String>
    lateinit var New_Crop_Detail: Array<String>
    lateinit var Intructions_to_Grow_The_Crop : Array<String>
    lateinit var Equiments_Required : Array<String>

    private lateinit var New_Crops_View_Model1 : New_Crops_View_Model


    var db = Firebase.firestore

    private var _binding : FragmentNewFarmingCropsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_new_farming__crops, container, false)

        New_Crops_View_Model1 = ViewModelProvider(requireActivity()).get(New_Crops_View_Model::class.java)

        _binding = FragmentNewFarmingCropsBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        count()

        val layoutManager = GridLayoutManager(this@New_farming_Crops.requireActivity(), 1)
        recyclerView = view.findViewById(R.id.recyclerView_new_crop_and_techniques)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        // dataList = arrayListOf<GovernmentSchemes>()
//        recyclerView.adapter = AdapterforGovernmentSchemes(dataList)
        adapter = Adapter_For_New_Crops(dataList)
        recyclerView.adapter = adapter
    }

    fun add3(count: Int){
        var a :Int= 1;
        var n = ""

        while(a < count+1) {

            val docRef = db.collection("New_Crops").document("${a}")
            docRef.get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val data =
                        documentSnapshot.toObject<New_Farming_Crop_Data_Class>(
                            New_Farming_Crop_Data_Class::class.java
                        )
                    // Access data fields (e.g., val item = data["item"])

                    if (data != null) {
                        Log.d("TAG", "DocumentSnapshot data: ${data.New_Crop_Name}")

                        New_Crop_name = New_Crop_name + data.New_Crop_Name.toString()
                        New_Crop_Image = New_Crop_Image + data.New_Crop_Image_Uri.toString()
                        New_Crop_Detail = New_Crop_Detail + data.New_Crop_Detail.toString()
                        Intructions_to_Grow_The_Crop = Intructions_to_Grow_The_Crop + data.Intruction_to_Grow_The_Crop.toString()
                        Equiments_Required = Equiments_Required + data.Equiments_Required.toString()

                        Log.d("TAG", "DocumentSnapshot data uri: ${data.New_Crop_Image_Uri}")
                        Log.d("TAG", "DocumentSnapshot data name: ${data.New_Crop_Name}")
                        Log.d(
                            "TAG",
                            "DocumentSnapshot data discri: ${data.Intruction_to_Grow_The_Crop}"
                        )
                        Log.d("TAG", "DocumentSnapshot data deta: ${data.New_Crop_Detail}")

                        val dataclass = New_Farming_Crop_Data_Class(
                            data.New_Crop_Image_Uri,
                            data.New_Crop_Name,
                            data.New_Crop_Detail,
                            data.Intruction_to_Grow_The_Crop,
                            data.Equiments_Required,
                        )
                        dataList.add(dataclass)

                        // add1(data.SchemesName,data.SchemesDiscription)
                        add1(dataList)

                        n = "Done"
                    } else {
                        // Document does not exist
                        Log.d("TAG", "DocumentSnapshot does not exist")
                    }
                } else {
                    Log.d("Tag", "Failed")
                }
            }
            a = a + 1

        }

    }

    private fun dataInitialize(){
        dataList = arrayListOf<New_Farming_Crop_Data_Class>()




        New_Crop_name = arrayOf(



        )
        New_Crop_Image = arrayOf(



        )
        New_Crop_Detail = arrayOf(


        )
        Intructions_to_Grow_The_Crop = arrayOf(

        )

        Equiments_Required = arrayOf(

        )

        for(i in New_Crop_name.indices){

            val dataclass = New_Farming_Crop_Data_Class(New_Crop_Image[i],New_Crop_name[i],New_Crop_Detail[i],Intructions_to_Grow_The_Crop[i],Equiments_Required[i])
            dataList.add(dataclass)
        }
    }

    fun add1(datalist1: ArrayList<New_Farming_Crop_Data_Class> ) {

        Log.d("TAG", "add1: $datalist1")
        adapter = Adapter_For_New_Crops(datalist1)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object : Adapter_For_New_Crops.onItemClickListener_New_Crops {

            override fun onItemClick(position: Int) {

                Log.d("TAG", "onItemClick: $position")
                Toast.makeText(this@New_farming_Crops.requireActivity(), "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
                //val transition: FragmentTransaction = childFragmentManager.beginTransaction()
                //.replace(R.id.fragment_container, FragmentHomeBinding)
                //  transition.commit()
//                val homeFragment = Home()
//                transition.replace(R.id.fragment_container, homeFragment)
//                transition.commit()

//                FarmerMainActivity.replaceFragment(Home())Home

                New_Crops_View_Model1.setData3(datalist1[position].New_Crop_Image_Uri)
                New_Crops_View_Model1.setData1(datalist1[position].New_Crop_Name)
                New_Crops_View_Model1.setData4(datalist1[position].New_Crop_Detail)
                New_Crops_View_Model1.setData5(datalist1[position].Intruction_to_Grow_The_Crop)

                New_Crops_View_Model1.setData7(datalist1[position].Equiments_Required)

                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(
                        R.id.fragment_container,
                        New_Crops_Discriptions::class.java,
                        null
                    ) // Replace with your FragmentContainerView's ID and the new Fragment class
                    addToBackStack(null)

                }
            }


        })

    }

    fun count (){
        var count : Int = 0

        val collectionRef = db.collection("New_Crops")

        collectionRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                count = task.result?.size() ?: 0
                println("Total documents: $count")
                Log.d("Tag","$count")
//                dataInitialize(count)
                add3(count)

            } else {
                println("Error fetching documents: ${task.exception}")
            }
        }

        dataInitialize()


    }


}