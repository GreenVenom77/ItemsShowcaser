package com.example.itemsshowcaser.itemdetails.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.itemsshowcaser.R
import com.example.itemsshowcaser.core.view.MainActivity
import com.example.itemsshowcaser.core.viewmodel.CoreViewModel
import com.example.itemsshowcaser.itemdetails.view.adapter.ImagePagerAdapter
import com.example.itemsshowcaser.itemdetails.view.adapter.ReviewsRecyclerViewAdapter

class DetailsFrag : Fragment() {
    private var productId: Int = 0
    private lateinit var viewModel: CoreViewModel
    private lateinit var imagesPager : ViewPager2
    private lateinit var title: TextView
    private lateinit var brand: TextView
    private lateinit var price: TextView
    private lateinit var status: TextView
    private lateinit var rating: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var description: TextView
    private lateinit var reviewsView: RecyclerView
    private lateinit var reviewsAdapter: ReviewsRecyclerViewAdapter
    private lateinit var imagesPagerAdapter: ImagePagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).showNavigateUp(true)
        viewModel = (activity as MainActivity).viewModel
        findViews(view)

        arguments?.let {
            productId = DetailsFragArgs.fromBundle(it).productId
        }
        fetchProductDetails(productId)
    }

    private fun fetchProductDetails(productId: Int) {
        val product = viewModel.productsResponse.value?.products?.get(productId)
        title.text = product?.title
        brand.text = product?.brand
        price.text = "Price: $${product?.price}"
        status.text = "Availability: ${product?.availabilityStatus}"
        rating.text = "${product?.rating}"
        ratingBar.rating = product?.rating?.toFloat() ?: 0f
        description.text = product?.description

        reviewsAdapter = ReviewsRecyclerViewAdapter(requireContext(), product?.reviews ?: emptyList())
        reviewsView.adapter = reviewsAdapter
        reviewsView.layoutManager = LinearLayoutManager(requireContext())

        imagesPagerAdapter = ImagePagerAdapter()
        imagesPager.adapter = imagesPagerAdapter
        imagesPagerAdapter.submitList(product?.images)
    }

    private fun findViews(view: View) {
        brand = view.findViewById<TextView>(R.id.productBrandDetail)
        title = view.findViewById<TextView>(R.id.productTitleDetail)
        price = view.findViewById<TextView>(R.id.productPriceDetail)
        status = view.findViewById<TextView>(R.id.productStatusDetail)
        rating = view.findViewById<TextView>(R.id.productRatingDetail)
        ratingBar = view.findViewById<RatingBar>(R.id.detailRatingBar)
        description = view.findViewById<TextView>(R.id.productDescriptionDetail)
        reviewsView = view.findViewById<RecyclerView>(R.id.reviewsRecyclerView)
        imagesPager = view.findViewById<ViewPager2>(R.id.imagesPager)
    }
}