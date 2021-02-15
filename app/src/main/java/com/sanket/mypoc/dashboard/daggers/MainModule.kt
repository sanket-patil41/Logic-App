package com.sanket.mypoc.dashboard.daggers

import com.sanket.mypoc.dashboard.repositories.MainRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MainModule  {

    @Singleton
    @Provides
    fun providesMainRepository():MainRepository{
        return MainRepository()
    }
}