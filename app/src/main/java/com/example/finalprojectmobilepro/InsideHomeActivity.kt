package com.example.finalprojectmobilepro

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.finalprojectmobilepro.databinding.FragmentInsideHomeBinding
import org.json.JSONArray

class InsideHomeActivity: AppCompatActivity() {
    private lateinit var queue: RequestQueue
    private lateinit var binding: FragmentInsideHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentInsideHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        queue = Volley.newRequestQueue(this)
        getProductList()

    }
    fun getProductList(){
        val url = "https://fakestoreapi.com/products/?limit=9"
        val stringRequest = StringRequest(url, Response.Listener<String>{ response ->
            val jsonArray = JSONArray(response.toString())
            Log.i("JSONRESPONSE", jsonArray.toString())
            binding.rvInsideHome.adapter = InsideHomeAdapter(jsonArray)
        },
            Response.ErrorListener { error ->
                Log.w("JSONRESPONSE", error.message as String)
            })

        queue.add(stringRequest)
    }

    override fun onStop() {
        super.onStop()
        queue.cancelAll("Stopped")
    }
}