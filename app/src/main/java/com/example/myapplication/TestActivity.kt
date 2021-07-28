package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class TestActivity  : AppCompatActivity()  {
    private lateinit var binding : ActivityMainBinding
    private var str1 : String = ""
    private var str2 : String = ""
    private var op1 : String?= null
    private var op2 : String?= null
    private var isMatch = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.btnsubmit.setOnClickListener {
            binding.tvOp1.text=""
            binding.tvOp2.text=""
            op1=""
            op2=""
         if(!binding.etFirst.text.isNullOrEmpty()||!binding.etSecond.text.isNullOrEmpty()){
             str1 = binding.etFirst.text.toString()
             str2 =  binding.etSecond.text.toString()
              processString(str1,str2)
         }else{
             Toast.makeText(applicationContext,"Please enter the strings",Toast.LENGTH_LONG).show()
         }
        }
    }
    private fun processString(str1 :String, str2:String){
        val chars1: CharArray = str1.toCharArray()
        val chars2: CharArray = str2.toCharArray()
        for(i in chars1){
            isMatch =false
            for(j in chars2){
                if(i==j)
                   isMatch = true
            }
            if(!isMatch)
                op1= "$op1$i" }
        for(i in chars2){
            isMatch =false
            for(j in chars1){
                if(i==j)
                    isMatch = true
            }
            if(!isMatch)
                op2= "$op2$i" }
        if(op1.isNullOrEmpty())
            binding.tvOp1.text="<null>"
        else
            binding.tvOp1.text=op1
        if(op2.isNullOrEmpty())
            binding.tvOp2.text="<null>"
        else
            binding.tvOp2.text=op2
    }
}