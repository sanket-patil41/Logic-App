package com.sanket.mypoc.dashboard.interfaces

import com.sanket.mypoc.dashboard.models.Fruit

interface AddMinusListener {
    fun addItem(fruit: Fruit)
    fun minusItem(fruit: Fruit)
}