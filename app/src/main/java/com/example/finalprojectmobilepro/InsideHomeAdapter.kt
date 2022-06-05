package com.example.finalprojectmobilepro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectmobilepro.databinding.ItemProductRandomBinding
import org.json.JSONArray
import org.json.JSONObject

class InsideHomeAdapter(private val products: JSONArray): RecyclerView.Adapter<InsideHomeAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsideHomeAdapter.ProductHolder {
        val binding = ItemProductRandomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding);
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.render(products.getJSONObject(position))
    }

    override fun getItemCount(): Int = products.length()

    class ProductHolder(val binding: ItemProductRandomBinding): RecyclerView.ViewHolder(binding.root){
        fun render(product: JSONObject){
            binding.ProductName.setText(product.getString("title"))
            binding.ProductReviews.setText(product.getString("count"))
            binding.ProductCost.setText((product.getString("price")))
            binding.ProductRating.rating = product.getString("rate").toFloat()

        }
    }
    }