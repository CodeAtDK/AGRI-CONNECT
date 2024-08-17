package com.example.agriconnect.New_Crop

import android.media.Image
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class New_Crops_View_Model : ViewModel() {

    private var Crops_Name = MutableLiveData<String>()
    private var Crops_Detail = MutableLiveData<String>()
    private var Crops_Image = MutableLiveData<String>()
    private var Intruction_to_Grow_The_Crop = MutableLiveData<String>()
    private var Equiments_Required = MutableLiveData<String>()

    fun setData1(postion:String){

        Crops_Name.value = postion
    }
    fun setData3(Criosimage:String){
        Crops_Image.value = Criosimage
    }
    fun setData4(postion:String){
        Crops_Detail.value = postion
    }
    fun setData5(postion: String){
        Intruction_to_Grow_The_Crop.value = postion
    }
    fun setData7(postion: String){
        Equiments_Required.value = postion
    }
    fun getData1(): LiveData<String> {

        return Crops_Name
    }
    fun getData4(): LiveData<String> {

        return Crops_Detail
    }
    fun getData3(): MutableLiveData<String> {

        return Crops_Image
    }
    fun getData5():MutableLiveData<String>{
        return Intruction_to_Grow_The_Crop
    }
    fun getData7():MutableLiveData<String>{
        return Equiments_Required
    }
}