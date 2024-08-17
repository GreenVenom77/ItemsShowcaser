package com.example.itemsshowcaser.itemdetails.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.itemsshowcaser.R
import com.example.itemsshowcaser.itemdetails.model.Review

class ReviewsRecyclerViewAdapter(
    private val context: Context,
    private var data: List<Review>,
): RecyclerView.Adapter<ReviewsRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById<TextView>(R.id.reviewerName)
        val date: TextView = itemView.findViewById<TextView>(R.id.reviewDate)
        val rating: TextView = itemView.findViewById<TextView>(R.id.reviewerRating)
        val comment: TextView = itemView.findViewById<TextView>(R.id.reviewerComment)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.review_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data[position].reviewerName
        holder.date.text = data[position].date
        holder.rating.text = "Rating: ${data[position].rating.toString()}"
        holder.comment.text = data[position].comment
    }

    override fun getItemCount(): Int {
        return data.size
    }
}