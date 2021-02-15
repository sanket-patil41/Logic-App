package com.sanket.mypoc.dashboard.daggers.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learncoding.cleanarchitecture.viewmodels.ViewModelFactory
import com.learncoding.cleanarchitecture.viewmodels.ViewModelKey
import com.sanket.mypoc.dashboard.viewmodels.SelectionViewModels
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import javax.inject.Singleton

@Module
abstract class ViewModelModule{

    @Binds
    @IntoMap
    @ViewModelKey(SelectionViewModels::class)
    abstract fun provideHomeViewModel(homeViewModel: SelectionViewModels):ViewModel


    @Binds
    @Singleton
    abstract fun provideViewModelFactory(viewModelFactory: ViewModelFactory):ViewModelProvider.Factory



}