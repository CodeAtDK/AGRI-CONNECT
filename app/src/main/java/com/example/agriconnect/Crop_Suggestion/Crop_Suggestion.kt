package com.example.agriconnect.Crop_Suggestion

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
import com.example.agriconnect.Crop_Suggestion.Crop_Discription.Crop_Detail
import com.example.agriconnect.New_Techniques.New_Techniques_Discription.New_Techniques_Discriptions
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentCropDetailBinding
import com.example.agriconnect.databinding.FragmentCropSuggestionBinding
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


class Crop_Suggestion : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : AdapterClass_for_Crop_Requriedments
    private lateinit var dataList : ArrayList<CropReuridments_DataClass>

    lateinit var Crop_Name : Array<String>
    lateinit var Crop_Img : Array<String>


    var db = Firebase.firestore

    private lateinit var MyViewModel_Crop_Requriment : Crop_Requriments_View_Model

    private var _binding : FragmentCropSuggestionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        MyViewModel_Crop_Requriment = ViewModelProvider(requireActivity()).get(Crop_Requriments_View_Model::class.java)

        // Inflate the layout for this fragment
        _binding = FragmentCropSuggestionBinding.inflate(inflater,container,false)
        return binding.root
       // return inflater.inflate(R.layout.fragment_crop__suggestion, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        add3()

        val layoutManager = GridLayoutManager(this@Crop_Suggestion.requireActivity(),2)
        recyclerView = view.findViewById(R.id.recyclerView_Crop_Requriment)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterClass_for_Crop_Requriedments(dataList)
        recyclerView.adapter = adapter
    }

    fun data2(count : Int) {

        var a: Int = 1;
        var n = ""
        while (a < count + 1) {
            val docRef = db.collection("Crop Requirements").document("${a}")
            docRef.get().addOnSuccessListener { documentSnapshot ->

                if (documentSnapshot.exists()) {
                    val data = documentSnapshot.toObject<CropReuridments_DataClass>(
                        CropReuridments_DataClass::class.java
                    )

                    if (data != null) {

                        Crop_Img = Crop_Img + data.ImageURI.toString()
                        Crop_Name = Crop_Name + data.CropName.toString()

                        val dataClass = CropReuridments_DataClass(

                            data.CropName,
                            data.ImageURI,
                        )
                        dataList.add(dataClass)

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
        fun add3(){

            var count : Int = 0
            val collectionRef = db.collection("Crop Requirements")

            collectionRef.get().addOnCompleteListener{ task ->
                if (task.isSuccessful){
                    count = task.result?.size() ?: 0
                    Log.d("Tag","$count")
                    data2(count)
                }
                else {
                    println("Error fetching documents: ${task.exception}")
                }
            }

            dataInitialize()

        }

    private fun dataInitialize() {
        dataList = arrayListOf<CropReuridments_DataClass>()

        var count : Int = 0

        Crop_Name = arrayOf(

        )
        Crop_Img = arrayOf(

        )
        for(i in Crop_Name.indices){

            val dataClass = CropReuridments_DataClass(Crop_Name[i],Crop_Img[i])
            dataList.add(dataClass)
        }
    }

    fun add1(datalist: ArrayList<CropReuridments_DataClass>){

        adapter = AdapterClass_for_Crop_Requriedments(dataList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object :
            AdapterClass_for_Crop_Requriedments.onItemClickListener{
            override fun onItemClick(position: Int) {
                Toast.makeText(this@Crop_Suggestion.requireActivity(),"Will Available Soon",Toast.LENGTH_SHORT).show()

                MyViewModel_Crop_Requriment.setData(datalist[position].CropName)
                MyViewModel_Crop_Requriment.setData1(datalist[position].ImageURI)

                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(
                        R.id.fragment_container,
                        Crop_Detail::class.java,
                        null
                    ) // Replace with your FragmentContainerView's ID and the new Fragment class
                    addToBackStack(null)

                }
            }
            }

        )
    }


}