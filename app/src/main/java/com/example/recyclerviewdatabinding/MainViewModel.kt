package com.example.recyclerviewdatabinding

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {


    var livedata:LiveData<List<Model>>

    init {
       this.livedata=Repository.getRemoteData()
    }


    fun canceljob(){
        Repository.canceljob()
    }
}