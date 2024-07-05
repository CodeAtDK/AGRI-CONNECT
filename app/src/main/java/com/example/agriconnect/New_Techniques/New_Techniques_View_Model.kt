package com.example.agriconnect.New_Techniques

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class New_Techniques_View_Model : ViewModel() {

    private var Techniques_Name = MutableLiveData<String>()
    private var Techniques_Discription = MutableLiveData<String>()
    private var Techniques_Detail = MutableLiveData<String>()
    private var Techniques_Image = MutableLiveData<String>()

    fun setData1(postion:String){

        Techniques_Name.value = postion
    }
    fun setData2(postion:String){
        Techniques_Discription.value = postion
    }
    fun setData3(Criosimage:String){
        Techniques_Image.value = Criosimage
    }
    fun setData4(postion:String){
        Techniques_Detail.value = postion
    }
    fun getData1(): LiveData<String> {

        return Techniques_Name
    }
    fun getData2(): LiveData<String> {

        return Techniques_Discription
    }
    fun getData4(): LiveData<String> {

        return Techniques_Detail
    }
    fun getData3(): MutableLiveData<String> {

        return Techniques_Image
    }
}
