package com.example.recyclerviewdatabinding

import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

object Repository {
     var job:CompletableJob?=null
    fun getRemoteData():MutableLiveData<List<Model>>{
        job=Job()
        return object :MutableLiveData<List<Model>>(){
            override fun onActive() {
                super.onActive()
                job?.let {

                    CoroutineScope(IO).launch {
                        var user=ApiBuilder.getAlluser(Api::class.java).getuser()
                        withContext(Main){
                            value=user
                            job?.complete()
                        }
                    }

                }

            }

        }

    }

    fun canceljob(){
        job?.cancel()
    }
}