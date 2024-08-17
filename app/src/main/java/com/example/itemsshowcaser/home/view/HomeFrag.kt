package com.example.itemsshowcaser.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.itemsshowcaser.R
import com.example.itemsshowcaser.core.view.MainActivity
import com.example.itemsshowcaser.core.viewmodel.CoreViewModel
import com.example.itemsshowcaser.home.view.adapter.HomeRecyclerViewAdapter

class HomeFrag : Fragment() {
    private lateinit var itemsView: RecyclerView
    private lateinit var adapter: HomeRecyclerViewAdapter
    private lateinit var viewModel: CoreViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).showNavigateUp(false)
        viewModel = (activity as MainActivity).viewModel
        itemsView = view.findViewById(R.id.homeRecyclerView)
        fetchProductsAndUpdateUI()
    }

    private fun navigateToDetails(productId: Int) {
        val action = HomeFragDirections.actionHomeFragToDetailsFrag(productId)
        findNavController().navigate(action)
    }

    private fun fetchProductsAndUpdateUI() {
        adapter = HomeRecyclerViewAdapter(requireContext(), emptyList()) { productId ->
            navigateToDetails(productId)
        }
        itemsView.adapter = adapter
        itemsView.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.productsResponse.observe(viewLifecycleOwner, Observer { productsResponse ->
            adapter.updateProducts(productsResponse.products)
        })
    }
}