package com.example.agriconnect.GovernmentSchemes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Government_Schemes_View_Model :ViewModel() {

    private var Scheme_Name = MutableLiveData<String>()
    private var Scheme_Discription = MutableLiveData<String>()

    fun setData1(postion:String){

        Scheme_Name.value = postion
    }
    fun setData2(postion:String){

        Scheme_Discription.value = postion
    }
    fun getData1(): LiveData<String> {

        return Scheme_Name
    }
    fun getData2(): LiveData<String> {

        return Scheme_Discription
    }
}