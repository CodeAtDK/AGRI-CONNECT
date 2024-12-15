package com.example.agriconnect.Crop_Suggestion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Crop_Requriments_View_Model : ViewModel(){

    private var Crop_Name = MutableLiveData<String>()
    private var Crop_Image = MutableLiveData<String>()
    private var Crop_Water_Level = MutableLiveData<String>()
    private var Crop_Discription = MutableLiveData<String>()

    fun setData(postion : String){

        Crop_Name.value = postion
    }
    fun setData1(postion: String){

        Crop_Image.value = postion
    }
    fun setData2(postion: String){

        Crop_Water_Level.value = postion
    }
    fun setData3(postion: String){

        Crop_Discription.value = postion
    }

    fun getData() : LiveData <String> {

        return Crop_Name
    }
    fun getData1() : LiveData <String> {

        return Crop_Image
    }
    fun getData2() : LiveData <String> {

        return Crop_Water_Level
    }
    fun getData3() : LiveData <String> {

        return Crop_Discription
    }
}