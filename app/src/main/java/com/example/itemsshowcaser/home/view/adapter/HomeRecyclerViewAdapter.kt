package com.example.itemsshowcaser.home.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itemsshowcaser.R
import com.example.itemsshowcaser.core.model.Product

class HomeRecyclerViewAdapter(
    private val onItemClick: (Int) -> Unit
): RecyclerView.Adapter<HomeRecyclerViewAdapter.ViewHolder>() {
    private var data: List<Product> = emptyList()
    private var context: Context? = null
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        init {
            itemView.setOnClickListener {
                var productId = data[bindingAdapterPosition].id
                onItemClick(--productId)
            }
        }

        val title: TextView = itemView.findViewById<TextView>(R.id.productTitle)
        val ratingBar: RatingBar = itemView.findViewById<RatingBar>(R.id.itemRatingBar)
        val reviewsCount: TextView = itemView.findViewById<TextView>(R.id.reviewsCount)
        val price: TextView = itemView.findViewById<TextView>(R.id.productPrice)
        val image: ImageView = itemView.findViewById<ImageView>(R.id.productImage)
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = data[position].title
        holder.ratingBar.rating = data[position].rating.toFloat()
        holder.reviewsCount.text = "(${data[position].reviews.size})"
        holder.price.text = "$${data[position].price.toString()}"
        context?.let { Glide.with(it).load(data[position].images[0]).into(holder.image) }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateProducts(newProducts: List<Product>) {
        data = newProducts
        notifyDataSetChanged()
    }
}