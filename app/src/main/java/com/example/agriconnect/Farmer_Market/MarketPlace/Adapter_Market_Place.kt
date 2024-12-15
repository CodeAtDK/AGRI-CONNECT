package com.example.agriconnect.Farmer_Market.MarketPlace

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.agriconnect.Farmer_Market.FarmerProduct
import com.example.agriconnect.New_Crop.Adapter_For_New_Crops
import com.example.agriconnect.R
import com.google.firebase.storage.FirebaseStorage

class Adapter_Market_Place (private val dataList_for_Market_Place : ArrayList<FarmerProduct>) :
    RecyclerView.Adapter<Adapter_Market_Place.MyViewHolder_Market_Place>()
{
        private lateinit var mListener1 : onItemClickListener_Market_Place

        interface onItemClickListener_Market_Place{

            fun onItemClick(position: Int)
        }

    fun setOnItemClickListener(listener: onItemClickListener_Market_Place){
        mListener1 = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter_Market_Place.MyViewHolder_Market_Place {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.market_palce_layout,parent,false)
        return MyViewHolder_Market_Place(item,mListener1)
    }

    override fun onBindViewHolder(
        holder: Adapter_Market_Place.MyViewHolder_Market_Place,
        position: Int
    ) {
        val currentItem = dataList_for_Market_Place[position]

        Log.d("TAG", "Image URL: ${currentItem.product_name}")
        Log.d("TAG", "Image URL: ${currentItem.product_img_Id_Url}")

        val storageReference = FirebaseStorage.getInstance().reference.child(currentItem.product_img_Id_Url.toString()) // Replace with actual path

        storageReference.downloadUrl.addOnSuccessListener { uri ->
            val imageUriString = uri.toString()

            holder.productname.text = currentItem.product_name
            holder.productPrice.text = "$ " + currentItem.product_price.toString()

            // Convert the URL string to a Uri object
            val imageUri = Uri.parse(imageUriString)

            Glide.with(holder.itemView.context)
                .load(uri)
                .placeholder(R.drawable.loding)
                .error(R.drawable.error)
                .into(holder.productImage)
        }.addOnFailureListener { exception ->
            // Handle any errors during the download
            Log.e("TAG", "Image download failed: ${exception.message}")
        }
    }

    override fun getItemCount(): Int {

        return dataList_for_Market_Place.size
    }

    class MyViewHolder_Market_Place(itemView : View, listener: onItemClickListener_Market_Place) : RecyclerView.ViewHolder(itemView){

        val productname : TextView = itemView.findViewById(R.id.Product_Name)
        val productPrice : TextView = itemView.findViewById(R.id.Product_Price)
        val productImage : ImageView = itemView.findViewById(R.id.Product_Image)

                init{

                    itemView.setOnClickListener{
                        listener.onItemClick(adapterPosition)
                    }
                }
    }
}