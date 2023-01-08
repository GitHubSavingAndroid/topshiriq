package com.example.topshiriq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.Person
import com.example.topshiriq.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.net.ssl.SSLSessionBindingEvent

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: RecyclerAdapter
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerAdapter=recyclerAdapter
        val retrofit=RetrofitHelper.getRetrofit()
        val cal=retrofit.create(NetworkApi::class.java)

        cal.getPost().enqueue(object :Callback<List<post>>{
            override fun onResponse(call: Call<List<post>>, response: Response<List<post>>) {
                recyclerAdapter.submitList(response.body())
            }

            override fun onFailure(call: Call<List<post>>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_SHORT).show()
            }

        })
    }
}