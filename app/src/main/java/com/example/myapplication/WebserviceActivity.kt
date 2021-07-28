package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.WebapiactivityBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebserviceActivity : AppCompatActivity() {

    private lateinit var binding : WebapiactivityBinding
    companion object {
        var BaseUrl :String ="https://reqres.in/api/users/"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = WebapiactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnsubmit.setOnClickListener(View.OnClickListener {
            callapi()
        })
    }

    fun callapi(){
        Toast.makeText(applicationContext,"First api calling",Toast.LENGTH_SHORT).show()
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(Apiservice::class.java)
        val call = service.callapi()
        call.enqueue(object : Callback<DataItems> {
            override fun onResponse(call: Call<DataItems>, response: Response<DataItems>) {
                if (response.code() == 200) {
                    val response1 = response.body()!!
                     val email= response1.data.email
                    binding.tvOne.text= email
                    callapi2()
                }
            }
            override fun onFailure(call: Call<DataItems>, t: Throwable) {
                Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show();
            }
        })
    }

    fun callapi2(){
        Toast.makeText(applicationContext,"Second api calling",Toast.LENGTH_SHORT).show()
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Apiservice::class.java)
        val call = service.callapi2()

        call.enqueue(object : Callback<DataItems> {
            override fun onResponse(call: Call<DataItems>, response: Response<DataItems>) {
                if (response.code() == 200) {

                    val response1 = response.body()!!

                    val email= response1.data.email
                    binding.tvTwo.text= email

                    callapi3()



                }
            }
            override fun onFailure(call: Call<DataItems>, t: Throwable) {
                Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show();
            }
        })


    }

    fun callapi3(){

        Toast.makeText(applicationContext,"Third api calling",Toast.LENGTH_SHORT).show()

        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Apiservice::class.java)
        val call = service.callapi3()

        call.enqueue(object : Callback<DataItems> {
            override fun onResponse(call: Call<DataItems>, response: Response<DataItems>) {
                if (response.code() == 200) {

                    val response1 = response.body()!!
                    val email= response1.data.email
                    binding.tvThree.text= email

                }
            }
            override fun onFailure(call: Call<DataItems>, t: Throwable) {
                Toast.makeText(applicationContext,"failed", Toast.LENGTH_LONG).show();
            }
        })


    }


}