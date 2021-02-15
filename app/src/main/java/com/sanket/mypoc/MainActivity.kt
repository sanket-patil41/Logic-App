package com.sanket.mypoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.learncoding.cleanarchitecture.viewmodels.ViewModelFactory
import com.sanket.mypoc.dashboard.SelectionFragment
import com.sanket.mypoc.dashboard.daggers.components.DaggerMainComponents
import com.sanket.mypoc.dashboard.interfaces.NavigateFragmentListener
import com.sanket.mypoc.dashboard.viewmodels.SelectionViewModels
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigateFragmentListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    //@Inject
    val selectionViewModels: SelectionViewModels by viewModels(){
        viewModelFactory
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponents.builder().build().inject(this)
       // selectionViewModels = ViewModelProvider(this, viewModelFactory).get(SelectionViewModels::class.java)
        replaceFragment(SelectionFragment())


    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.framecontainer, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun replaceFragments(fragment: Fragment) {
        replaceFragment(fragment)
    }
}