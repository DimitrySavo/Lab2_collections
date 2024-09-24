package com.example.lab2_collections

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2_collections.databinding.FragmentArrayBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArrayFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArrayFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentArrayBinding
    private lateinit var adapter: ArrayAdapter
    private var dataList = emptyArray<String>()

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
        binding = FragmentArrayBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner

        binding.arraySize.minValue = 1
        binding.arraySize.maxValue = 100
        binding.arraySize.setOnValueChangedListener { picker, oldVal, newVal ->
            updateArraySize(newVal)
        }

        binding.arrayRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = ArrayAdapter(dataList)
        binding.arrayRecyclerView.adapter = adapter
        setupSearch()

        return binding.root
    }



    private fun setupSearch(){
        binding.searchArray.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                val filteredArray = if (!newText.isNullOrEmpty()){
                    dataList.filter { it.contains(newText) }.toTypedArray()
                } else {
                    dataList
                }
                adapter.updateArray(filteredArray)
                return true
            }

        })
    }

    private fun updateArraySize(size: Int) {
        dataList = Array(size) { i-> "Item $i"}
        adapter.updateArray(dataList)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ArrayFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ArrayFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}


