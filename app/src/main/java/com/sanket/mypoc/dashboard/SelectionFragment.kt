package com.sanket.mypoc.dashboard

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sanket.mypoc.R
import com.sanket.mypoc.dashboard.adapters.SelectionAdapter
import com.sanket.mypoc.dashboard.fragments.ConfirmFragment
import com.sanket.mypoc.dashboard.interfaces.AddMinusListener
import com.sanket.mypoc.dashboard.interfaces.NavigateFragmentListener
import com.sanket.mypoc.dashboard.models.Fruit
import com.sanket.mypoc.dashboard.viewmodels.SelectionViewModels

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectionFragment : Fragment(), AddMinusListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var recylerview: RecyclerView
    lateinit var btn_submit:Button
    lateinit var selectionAdapter: SelectionAdapter
    val selectionViewModels: SelectionViewModels by activityViewModels()
    lateinit var navigateFragmentListener:NavigateFragmentListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_selection, container, false)
        init(view)
        initRecylerview()
        observerViewModels()
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigateFragmentListener = context as NavigateFragmentListener
    }
    companion object {
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SelectionFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun init(view: View) {
        recylerview = view.findViewById(R.id.recylerview)
        selectionAdapter = SelectionAdapter(requireActivity(), this)
        btn_submit = view.findViewById(R.id.btn_submit)
        btn_submit.setOnClickListener({
            navigateFragmentListener.replaceFragments(ConfirmFragment())
        })
    }

    fun initRecylerview() {
        recylerview.apply {
            layoutManager = LinearLayoutManager(activity)
            setItemAnimator(DefaultItemAnimator())
            addItemDecoration(
                DividerItemDecoration(
                    activity,
                    DividerItemDecoration.VERTICAL
                )
            )
            setHasFixedSize(true)
            adapter = selectionAdapter
        }
    }

    fun observerViewModels() {
        var isCalled = true
        selectionViewModels.getFruits().observe(viewLifecycleOwner, {
            it?.let {
                selectionAdapter.setData(it.values.toList())

            }
        })
//        selectionViewModels.getSelectedFruits().observe(viewLifecycleOwner, {
//            it?.let {
//                selectionAdapter.setSelectedData(it.values.toList())
//            }
//        })
    }

    override fun addItem(fruit: Fruit) {
        selectionViewModels.addFruits(fruit)
    }

    override fun minusItem(fruit: Fruit) {
        selectionViewModels.minusFruits(fruit)
    }
}