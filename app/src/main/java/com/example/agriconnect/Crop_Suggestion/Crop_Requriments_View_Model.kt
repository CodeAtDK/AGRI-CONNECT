package com.example.agriconnect.Crop_Suggestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Crop_Requriments_View_Model : ViewModel(){

    private var Crop_Name = MutableLiveData<String>()
    private var Crop_Image = MutableLiveData<String>()

    fun setData(postion : String){

        Crop_Name.value = postion
    }
    fun setData1(postion: String){

        Crop_Image.value = postion
    }

    fun getData() : LiveData <String> {

        return Crop_Name
    }
    fun getData1() : LiveData <String> {

        return Crop_Image
    }
}