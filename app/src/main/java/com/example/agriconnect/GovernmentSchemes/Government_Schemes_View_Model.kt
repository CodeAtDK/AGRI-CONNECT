package com.example.agriconnect.GovernmentSchemes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class Government_Schemes_View_Model :ViewModel() {

    private var Scheme_Name = MutableLiveData<String>()
    private var Scheme_Discription = MutableLiveData<String>()
    private var Scheme_Benefits = MutableLiveData<String>()
    private var Scheme_Eligibility = MutableLiveData<String>()
    private var Documents_Required = MutableLiveData<String>()
    private var Scheme_Link = MutableLiveData<String>()

    fun setData1(postion:String){

        Scheme_Name.value = postion
    }
    fun setData2(postion:String){

        Scheme_Discription.value = postion
    }
    fun setData3(postion:String){
        Scheme_Benefits.value = postion
    }
    fun setData4(postion:String){
        Scheme_Eligibility.value = postion

    }
    fun setData5(postion:String){
        Documents_Required.value = postion

    }
    fun setData6(postion: String){
        Scheme_Link.value = postion
    }
    fun getData1(): LiveData<String> {

        return Scheme_Name
    }
    fun getData2(): LiveData<String> {

        return Scheme_Discription
    }
    fun getData3(): LiveData<String> {
        return Scheme_Benefits
    }
    fun getData4(): LiveData<String> {
        return Scheme_Eligibility
    }
    fun getData5(): LiveData<String> {
        return Documents_Required
    }
    fun getData6(): LiveData<String>{
        return Scheme_Link
    }
}