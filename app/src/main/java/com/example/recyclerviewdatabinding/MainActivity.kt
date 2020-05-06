package com.example.recyclerviewdatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
 lateinit var modeldata:MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        modeldata=ViewModelProvider.AndroidViewModelFactory(application).create(MainViewModel::class.java)
       var data= modeldata.livedata
        data.observe(this, Observer {it->
          var adapteruser=  MyAdapter(this,it)
            recyclerview.also { it->
                it.layoutManager=LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter=adapteruser
                adapteruser.notifyDataSetChanged()

            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
        modeldata.canceljob()
    }


    }

