package com.example.agriconnect.New_Crop

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class New_Crops_View_Model : ViewModel() {

    private var Crops_Name = MutableLiveData<String>()
    private var Crops_Discription = MutableLiveData<String>()
    private var Crops_Detail = MutableLiveData<String>()
    private var Crops_Image = MutableLiveData<String>()

    fun setData1(postion:String){

        Crops_Name.value = postion
    }
    fun setData2(postion:String){
        Crops_Discription.value = postion
    }
    fun setData3(Criosimage:String){
        Crops_Image.value = Criosimage
    }
    fun setData4(postion:String){
        Crops_Detail.value = postion
    }
    fun getData1(): LiveData<String> {

        return Crops_Name
    }
    fun getData2(): LiveData<String> {

        return Crops_Discription
    }
    fun getData4(): LiveData<String> {

        return Crops_Detail
    }
    fun getData3(): MutableLiveData<String> {

        return Crops_Image
    }
}