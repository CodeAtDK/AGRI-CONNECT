package com.example.agriconnect.Crop_Suggestion

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agriconnect.R
import com.google.firebase.storage.FirebaseStorage

class AdapterClass_for_Crop_Requriedments(private val dataList_for_Crop_Requridments: ArrayList<CropReuridments_DataClass>) :
    RecyclerView.Adapter<AdapterClass_for_Crop_Requriedments.MyViewHolder>(){

        //private var itemlayout = R.layout.croprequridmentinfalter
            private lateinit var mListener : onItemClickListener

            interface onItemClickListener{

                fun onItemClick(position: Int)
            }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterClass_for_Crop_Requriedments.MyViewHolder {

        val item = LayoutInflater.from(parent.context).inflate(R.layout.croprequridmentinfalter,parent,false)
        return MyViewHolder(item,mListener)
    }



    override fun onBindViewHolder(holder: AdapterClass_for_Crop_Requriedments.MyViewHolder, position: Int) {

        val currentItem = dataList_for_Crop_Requridments[position]



        val storageReference = FirebaseStorage.getInstance().reference.child(currentItem.ImageURI.toString()) // Replace with actual path

        storageReference.downloadUrl.addOnSuccessListener { uri ->
            val imageUriString = uri.toString()

            holder.CropName.text = currentItem.CropName

            // Convert the URL string to a Uri object
            val imageUri = Uri.parse(imageUriString)

            Glide.with(holder.itemView.context)
                .load(uri)
                .placeholder(R.drawable.government_schemes)
                .error(R.drawable.new_farming_crops)
                .into(holder.CropImg)
        }.addOnFailureListener { exception ->
            // Handle any errors during the download
            Log.e("TAG", "Image download failed: ${exception.message}")
        }

    }

    override fun getItemCount(): Int {

        return dataList_for_Crop_Requridments.size
    }

    class MyViewHolder (itemview: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemview){

        val CropName : TextView = itemview.findViewById(R.id.Crop_Name_of_Requridment)
        val CropImg : ImageView = itemview.findViewById(R.id.Crop_Image_of_Requriedments)

        init{

            itemView.setOnClickListener{

                listener.onItemClick(adapterPosition)
            }
        }

    }
}