package com.example.myapplication

import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getRepos();
    }

     private fun getRepos() {

        val request = ServiceBuilder.buildService(Github::class.java)
        val call = request.getRepos()

        call.enqueue(object : Callback<PopularRepos> {
            override fun onResponse(call: Call<PopularRepos>, response: Response<PopularRepos>) {
                if (response.isSuccessful) {

                    recyclerView.setHasFixedSize(true)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.adapter = ReposAdapter(response.body()!!.items)
                }
            }

            override fun onFailure(call: Call<PopularRepos>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }


}

