package com.sanket.mypoc.dashboard.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sanket.mypoc.dashboard.models.Fruit
import com.sanket.mypoc.dashboard.repositories.MainRepository

class SelectionViewModels : ViewModel() {

    val mainRepository: MainRepository

    init {
        mainRepository = MainRepository()
    }

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