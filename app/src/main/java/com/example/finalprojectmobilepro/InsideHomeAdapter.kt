package com.example.finalprojectmobilepro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalprojectmobilepro.databinding.ItemProductRandomBinding
import org.json.JSONArray

class RandomAdapter(private val products: JSONArray): RecyclerView.Adapter<RandomAdapter.ProductHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomAdapter.ProductHolder {
        val binding = ItemProductRandomBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductHolder(binding);
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.render(products.getJSONObject(position))
    }

    override fun getItemCount(): Int = products.length()

    class ProductHolder(val binding: ItemProductRandomBinding): RecyclerView.ViewHolder(binding.root){

    }
    }