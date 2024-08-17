package com.example.agriconnect.New_Techniques

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class New_Techniques_View_Model : ViewModel() {

    private var Techniques_Name = MutableLiveData<String>()
    private var Techniques_Detail = MutableLiveData<String>()
    private var Techniques_Image = MutableLiveData<String>()
    private var List_Of_Benfits = MutableLiveData<String>()
    private var Way_Of_Implementation_In_Details = MutableLiveData<String>()
    private var RequiredEquipments = MutableLiveData<String>()
    private var EquipmentsLink = MutableLiveData<String>()

    fun setData1(postion:String){

        Techniques_Name.value = postion
    }
    fun setData3(Criosimage:String){
        Techniques_Image.value = Criosimage
    }
    fun setData4(postion:String){
        Techniques_Detail.value = postion
    }
    fun setData5(postion: String){
        List_Of_Benfits.value = postion
    }
    fun setData6(postion: String){
        Way_Of_Implementation_In_Details.value = postion
    }
    fun setData7(postion: String){
        RequiredEquipments.value = postion
    }
    fun setData8(postion: String){
        EquipmentsLink.value = postion
    }
    fun getData1(): LiveData<String> {

        return Techniques_Name
    }
    fun getData4(): LiveData<String> {

        return Techniques_Detail
    }
    fun getData3(): MutableLiveData<String> {

        return Techniques_Image
    }
    fun getData5() : MutableLiveData<String> {
        return List_Of_Benfits
    }
    fun getData6() : MutableLiveData<String> {
        return Way_Of_Implementation_In_Details
    }
    fun getData7() : MutableLiveData<String> {
        return RequiredEquipments
    }
    fun getData8() : MutableLiveData<String> {
        return EquipmentsLink
    }
}
