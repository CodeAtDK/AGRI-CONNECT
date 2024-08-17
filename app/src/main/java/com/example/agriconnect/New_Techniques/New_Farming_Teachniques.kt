package com.example.agriconnect.New_Techniques

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agriconnect.New_Crop.Adapter_For_New_Crops
import com.example.agriconnect.New_Crop.New_Crops_Discription.New_Crops_Discriptions
import com.example.agriconnect.New_Crop.New_Farming_Crop_Data_Class
import com.example.agriconnect.New_Techniques.New_Techniques_Discription.New_Techniques_Discriptions
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentNewFarmingTeachniquesBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class New_Farming_Teachniques : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: Adapter_New_Farming_Teachniques
    private lateinit var dataList1: ArrayList<New_Techniques_Data_Class>

    lateinit var New_Techniques_Name: Array<String>
    lateinit var New_Techniques_Image: Array<String>
    lateinit var New_Techniques_Detail: Array<String>
    lateinit var New_Techniques_Benfits: Array<String>
    lateinit var New_Techniques_Ways_of_implementation: Array<String>
    lateinit var New_Techniques_Equipments: Array<String>
    lateinit var Equipments_Link : Array<String>

    private lateinit var New_Techniques_View_Model1: New_Techniques_View_Model

    var db = Firebase.firestore

    private var _binding: FragmentNewFarmingTeachniquesBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //  return inflater.inflate(R.layout.fragment_new__farming__teachniques, container, false)

        New_Techniques_View_Model1 =
            ViewModelProvider(requireActivity()).get(New_Techniques_View_Model::class.java)

        _binding = FragmentNewFarmingTeachniquesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add3()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView_techniques)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        // dataList = arrayListOf<GovernmentSchemes>()
//        recyclerView.adapter = AdapterforGovernmentSchemes(dataList)
        adapter = Adapter_New_Farming_Teachniques(dataList1)
        recyclerView.adapter = adapter
    }

    fun data2(count: Int){

        var a: Int = 1;
        var n = ""
        while (a < count+1) {

            val docRef = db.collection("New Techniques").document("${a}")
            docRef.get().addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val data =
                        documentSnapshot.toObject<New_Techniques_Data_Class>(
                            New_Techniques_Data_Class::class.java
                        )
                    // Access data fields (e.g., val item = data["item"])

                    if (data != null) {
                        Log.d("TAG", "DocumentSnapshot data: ${data.New_Techniques_Name}")

                        New_Techniques_Image = New_Techniques_Image + data.New_Techniques_Image_Uri.toString()
                        New_Techniques_Name = New_Techniques_Name + data.New_Techniques_Name.toString()
                        New_Techniques_Benfits = New_Techniques_Benfits + data.ListofBenfits.toString()
                        New_Techniques_Ways_of_implementation = New_Techniques_Ways_of_implementation + data.WayInDetail.toString()
                        New_Techniques_Equipments = New_Techniques_Equipments + data.RequiredEquipments.toString()
                        Equipments_Link = Equipments_Link + data.EquipmentsLink.toString()

                        Log.d("TAG", "DocumentSnapshot data uri: ${data.New_Techniques_Image_Uri}")
                        Log.d("TAG", "DocumentSnapshot data name: ${data.New_Techniques_Name}")
                        Log.d(
                            "TAG",
                            "DocumentSnapshot data discri: ${data.ListofBenfits}"
                        )
                        Log.d("TAG", "DocumentSnapshot data deta: ${data.New_Techniques_Detail}")

                        val dataclass = New_Techniques_Data_Class(
                            data.New_Techniques_Image_Uri,
                            data.New_Techniques_Name,
                            data.New_Techniques_Detail,
                            data.ListofBenfits,
                            data.WayInDetail,
                            data.RequiredEquipments,
                            data.EquipmentsLink,
                        )
                        dataList1.add(dataclass)

                        // add1(data.SchemesName,data.SchemesDiscription)
                        add1(dataList1)

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

    fun add3(){

        var count : Int = 0
        val collectionRef = db.collection("New Techniques")

        collectionRef.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                count = task.result?.size() ?: 0
                println("Total documents: $count")
                Log.d("Tag","$count")
                data2(count)

            } else {
                println("Error fetching documents: ${task.exception}")
            }
        }

        dataInitialize()

    }
    private fun dataInitialize() {
        dataList1 = arrayListOf<New_Techniques_Data_Class>()

        var count : Int = 0



        New_Techniques_Name = arrayOf(

        )
        New_Techniques_Image = arrayOf(

        )
        New_Techniques_Detail = arrayOf(

        )
        New_Techniques_Benfits = arrayOf(

        )
        New_Techniques_Ways_of_implementation = arrayOf(

        )
        New_Techniques_Equipments = arrayOf(

        )
        Equipments_Link = arrayOf(

        )
        for(i in New_Techniques_Name.indices){

            val dataclass1 = New_Techniques_Data_Class(New_Techniques_Image[i],New_Techniques_Name[i],New_Techniques_Detail[i],New_Techniques_Benfits[i],New_Techniques_Ways_of_implementation[i],New_Techniques_Equipments[i],Equipments_Link[i])
            dataList1.add(dataclass1)
        }
        }



    fun add1(datalist1: ArrayList<New_Techniques_Data_Class>) {

            Log.d("TAG", "add1: $datalist1")
             adapter = Adapter_New_Farming_Teachniques(datalist1)
            recyclerView.adapter = adapter

            adapter.setOnItemClickListener(object :
                Adapter_New_Farming_Teachniques.onItemClickListener_New_Techniques {

                override fun onItemClick(position: Int) {

                    Log.d("TAG", "onItemClick: $position")
                Toast.makeText(this@New_Farming_Teachniques.requireActivity(), "You clicked on item no. $position", Toast.LENGTH_SHORT).show()
                //val transition: FragmentTransaction = childFragmentManager.beginTransaction()
                //.replace(R.id.fragment_container, FragmentHomeBinding)
                //  transition.commit()
//                val homeFragment = Home()
//                transition.replace(R.id.fragment_container, homeFragment)
//                transition.commit()

//                FarmerMainActivity.replaceFragment(Home())Home

                New_Techniques_View_Model1.setData3(datalist1[position].New_Techniques_Image_Uri)
                New_Techniques_View_Model1.setData1(datalist1[position].New_Techniques_Name)
                New_Techniques_View_Model1.setData4(datalist1[position].New_Techniques_Detail)
                    New_Techniques_View_Model1.setData5(datalist1[position].ListofBenfits)
                    New_Techniques_View_Model1.setData6(datalist1[position].WayInDetail)
                    New_Techniques_View_Model1.setData7(datalist1[position].RequiredEquipments)
                    New_Techniques_View_Model1.setData8(datalist1[position].EquipmentsLink)

                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(
                            R.id.fragment_container,
                            New_Techniques_Discriptions::class.java,
                            null
                        ) // Replace with your FragmentContainerView's ID and the new Fragment class
                        addToBackStack(null)

                    }
                }


            })

        }


    }
