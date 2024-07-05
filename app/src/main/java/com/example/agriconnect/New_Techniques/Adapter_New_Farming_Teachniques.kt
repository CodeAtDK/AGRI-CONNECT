package com.example.agriconnect.New_Techniques

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agriconnect.New_Crop.Adapter_For_New_Crops
import com.example.agriconnect.R
import com.google.firebase.storage.FirebaseStorage

class Adapter_New_Farming_Teachniques (private val dataList_For_New_Techinques : ArrayList<New_Techniques_Data_Class>) :
    RecyclerView.Adapter<Adapter_New_Farming_Teachniques.MyViewHolder_New_Techniques>()
{

        private lateinit var mListener :onItemClickListener_New_Techniques

        interface onItemClickListener_New_Techniques{

            fun onItemClick(position : Int)

        }

    fun setOnItemClickListener(listener : onItemClickListener_New_Techniques){

        mListener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter_New_Farming_Teachniques.MyViewHolder_New_Techniques {

        val item = LayoutInflater.from(parent.context).inflate(R.layout.new_farming_teachniques_details,parent,false)
        return MyViewHolder_New_Techniques(item,mListener)
    }

    override fun onBindViewHolder(
        holder: Adapter_New_Farming_Teachniques.MyViewHolder_New_Techniques,
        position: Int
    ) {

        val currentItem = dataList_For_New_Techinques[position]

        Log.d("TAG", "Image URL: ${currentItem.New_Techniques_Image_Uri}")
        Log.d("TAG", "Image URL: ${currentItem.New_Techniques_Name}")

        val storageReference = FirebaseStorage.getInstance().reference.child(currentItem.New_Techniques_Image_Uri.toString()) // Replace with actual path

        storageReference.downloadUrl.addOnSuccessListener { uri ->
            val imageUriString = uri.toString()

            holder.New_Techniques_Name.text = currentItem.New_Techniques_Name

            // Convert the URL string to a Uri object
            val imageUri = Uri.parse(imageUriString)

            Glide.with(holder.itemView.context)
                .load(uri)
                .placeholder(R.drawable.government_schemes)
                .error(R.drawable.new_farming_crops)
                .into(holder.New_Techniques_Image)
        }.addOnFailureListener { exception ->
            // Handle any errors during the download
            Log.e("TAG", "Image download failed: ${exception.message}")
        }

    }

    override fun getItemCount(): Int {
        return dataList_For_New_Techinques.size
    }

    class MyViewHolder_New_Techniques(itemView : View , listener: onItemClickListener_New_Techniques) : RecyclerView.ViewHolder(itemView){

        val New_Techniques_Name : TextView = itemView.findViewById(R.id.Text_for_new_techniques)
        val New_Techniques_Image : ImageView = itemView.findViewById(R.id.Image_for_new_Techniques)

        init {

            itemView.setOnClickListener{

                listener.onItemClick(adapterPosition)
            }
        }
    }
}