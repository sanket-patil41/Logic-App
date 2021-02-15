package com.sanket.mypoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.sanket.mypoc.dashboard.SelectionFragment
import com.sanket.mypoc.dashboard.interfaces.NavigateFragmentListener
import com.sanket.mypoc.dashboard.viewmodels.SelectionViewModels

class MainActivity : AppCompatActivity() , NavigateFragmentListener {
    val selectionViewModels: SelectionViewModels by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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