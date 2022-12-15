package com.skgames.trafficridert.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.skgames.trafficridert.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import javax.inject.Inject


@OptIn(ExperimentalCoroutinesApi::class)
@HiltViewModel
class OnyxViewModel
@Inject constructor(private val repository: Repository) : ViewModel(){



    fun getData() = liveData(Dispatchers.IO){
          repository.getData().collect{
            result->
              emit(result)
          }
    }

    fun getDataDev() = liveData(Dispatchers.IO){
        repository.getDataDev().collect{
            result->
            emit(result)
        }
    }

}