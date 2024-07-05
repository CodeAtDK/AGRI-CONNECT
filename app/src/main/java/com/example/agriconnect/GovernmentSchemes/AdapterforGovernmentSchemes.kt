package com.example.agriconnect.GovernmentSchemes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.example.agriconnect.Basic.SignUp
import com.example.agriconnect.R
import com.example.agriconnect.databinding.FragmentHomeBinding


class AdapterforGovernmentSchemes(private val dataList:ArrayList<GovernmentSchemes>):
    RecyclerView.Adapter<AdapterforGovernmentSchemes.MyViewHolder>()
     {

        private var itemlayout = R.layout.government_schemes_layout

         private lateinit var mListener : onItemClickListener

         interface onItemClickListener{

             fun onItemClick(position: Int)
         }

         fun setOnItemClickListener(listener: onItemClickListener){

             mListener = listener
         }



         override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

             val item = LayoutInflater.from(parent.context).inflate(itemlayout,parent,false)
             return MyViewHolder(item,mListener)


         }

         override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

             val currentItem = dataList[position]
            // holder.Image.setImageResource(currentItem.titleImg)
             holder.schemeName.text = currentItem.SchemesName




                 holder.schemeDisbrtion.text = currentItem.SchemesDiscription
                 holder.schemeDisbrtion.paddingTop



         }

         override fun getItemCount(): Int {

             return dataList.size

         }



         class MyViewHolder (itemview: View, listener: onItemClickListener):RecyclerView.ViewHolder(itemview){

            // val Image : ShapeableImageView = itemview.findViewById<ShapeableImageView>(R.id.Image_id)
             val schemeName : TextView = itemview.findViewById(R.id.textviewgovernmentscheme)
             val schemeDisbrtion:TextView = itemview.findViewById(R.id.textviewgovernmentschemeDescription)

             init {

                 itemView.setOnClickListener{

                     listener.onItemClick(adapterPosition)


                 }

             }

         }


     }

