package com.sanket.mypoc.dashboard.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanket.mypoc.dashboard.models.Fruit
import com.sanket.mypoc.dashboard.repositories.MainRepository
import javax.inject.Inject

class SelectionViewModels @Inject constructor(var  mainRepository: MainRepository): ViewModel() {


    fun getFruits(): MutableLiveData<Map<String, Fruit>> {

        return mainRepository.mutablefruitList
    }

    fun getSelectedFruits(): MutableLiveData<Map<String, Fruit>> {
        return mainRepository.selectedMutablefruitList
    }

    fun addFruits(fruit: Fruit) {
        mainRepository.addFruits(fruit)
    }

    fun minusFruits(fruit: Fruit) {
        mainRepository.minusFruits(fruit)
    }
}