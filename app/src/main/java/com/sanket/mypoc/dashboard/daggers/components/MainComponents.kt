package com.sanket.mypoc.dashboard.daggers.components

import com.sanket.mypoc.MainActivity
import com.sanket.mypoc.dashboard.SelectionFragment
import com.sanket.mypoc.dashboard.daggers.MainModule
import com.sanket.mypoc.dashboard.daggers.modules.ViewModelModule
import com.sanket.mypoc.dashboard.fragments.ConfirmFragment
import com.sanket.mypoc.dashboard.repositories.MainRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class,ViewModelModule::class])
interface MainComponents {
    fun inject(mainActivity: MainActivity)
    fun inject(fragment: SelectionFragment)
    fun inject(fragment: ConfirmFragment)
}