package com.example.agriconnect.New_Crop

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agriconnect.GovernmentSchemes.AdapterforGovernmentSchemes
import com.example.agriconnect.R
import com.google.firebase.storage.FirebaseStorage

class Adapter_For_New_Crops (private val dataList_for_New_Crop:ArrayList<New_Farming_Crop_Data_Class> ):
    RecyclerView.Adapter<Adapter_For_New_Crops.MyViewHolder_New_Crops>()

{

        private lateinit var mListener :onItemClickListener_New_Crops

        interface onItemClickListener_New_Crops{

            fun onItemClick(position: Int)
        }

    fun setOnItemClickListener(listener: onItemClickListener_New_Crops){

        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder_New_Crops {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.new_crop_and_techniques_layout,parent,false)
        return MyViewHolder_New_Crops(item,mListener)
    }

    override fun getItemCount(): Int {
        return dataList_for_New_Crop.size
    }

    override fun onBindViewHolder(holder: MyViewHolder_New_Crops, position: Int) {

//        val currentItem = dataList_for_New_Crop[position]
//        holder.New_Crop_Name.text = currentItem.New_Crop_Name
        val currentItem = dataList_for_New_Crop[position]

        Log.d("TAG", "Image URL: ${currentItem.New_Crop_Image_Uri}")
        Log.d("TAG", "Image URL: ${currentItem.New_Crop_Name}")

        val storageReference = FirebaseStorage.getInstance().reference.child(currentItem.New_Crop_Image_Uri.toString()) // Replace with actual path

        storageReference.downloadUrl.addOnSuccessListener { uri ->
            val imageUriString = uri.toString()

            holder.New_Crop_Name.text = currentItem.New_Crop_Name

            // Convert the URL string to a Uri object
            val imageUri = Uri.parse(imageUriString)

            Glide.with(holder.itemView.context)
                .load(uri)
                .placeholder(R.drawable.government_schemes)
                .error(R.drawable.new_farming_crops)
                .into(holder.New_Img)
        }.addOnFailureListener { exception ->
            // Handle any errors during the download
            Log.e("TAG", "Image download failed: ${exception.message}")
        }


    }

    class MyViewHolder_New_Crops(itemView: View, listener: onItemClickListener_New_Crops) : RecyclerView.ViewHolder(itemView){

        val New_Crop_Name : TextView = itemView.findViewById(R.id.Text_for_new_crop_and_techniq)
        val New_Img : ImageView = itemView.findViewById(R.id.Image_for_new_crop_and_techniq)
        //val New_Crop_Disbrtion: TextView = itemView.findViewById(R.id.textviewgovernmentschemeDescription)

        init{
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }

    }


}