package com.example.finalprojectmobilepro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.example.finalprojectmobilepro.database.Product
import com.example.finalprojectmobilepro.databinding.ActivityMainBinding
import com.example.finalprojectmobilepro.firebas.User
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.squareup.picasso.Picasso
import org.json.JSONArray

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var queue: RequestQueue
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef = database.reference

        //myRef.child("users").child("1").setValue(User(1, "Alfredo Sanchez", "Tejarock",4,1))
        //myRef.child("users").child("2").setValue(User(2, "Pancho Lara", "ElPEPE",5,2))
        //myRef.child("users").child("3").setValue(User(3, "Jose Magrigal", "ElMesias",1,3))

        myRef.child("users").get().addOnSuccessListener { response ->
            Log.d("firebaseResponse", response.value.toString())
        }.addOnFailureListener {
            Log.e("firebaseResponse", "Error getting data", it)
        }


/*
        mainViewModel.saveProduct(Product(
            1,
            "FruitCola",
            1.73,
            "Es un refresco hecho con frutas naturales.",
            3.5
        ))

 */
        mainViewModel.getProducts()
        //Nota:
        //si es en un fragment
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.savedProducts.observe(this, {productsList ->
            if(!productsList.isNullOrEmpty()){
                for(product in productsList){
                    Log.d("thesearetheproducts", product.product_name)
                }
            }else{
                Log.d("thesearetheproducts", "null or empty")
            }
        })


        fun getProductList(){
            val url = "https://fakestoreapi.com/products/?limit=9"
            val stringRequest = StringRequest(url, Response.Listener<String>{ response ->
                val jsonArray = JSONArray(response.toString())
                Log.i("JSONRESPONSE", jsonArray.toString())
                binding.rvPokeEntries.adapter = MainAdapter(jsonArray)
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
}