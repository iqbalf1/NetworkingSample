package com.binar.networkingsample2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.binar.networkingsample2.databinding.ActivityMainBinding
import com.binar.networkingsample2.model.GetAllCarResponseItem
import com.binar.networkingsample2.network.CarsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var bindig : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindig = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindig.root)


    }
}