package com.skgames.trafficridert.repository

import com.skgames.trafficridert.api.ApiInterface
import com.skgames.trafficridert.api.HostInterface
import com.skgames.trafficridert.utils.StateConnetion
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

@ExperimentalCoroutinesApi
class Repository @Inject constructor(private val apiInterface: ApiInterface, private val hostInterface: HostInterface) {

      fun getData() = flow{
          emit(StateConnetion.loading())
          try {
              val apires = apiInterface.getData()
              emit(StateConnetion.success(apires))
          }catch (e:IOException){
              emit(StateConnetion.failed(e.message.toString()))
          }

      }

    fun getDataDev() = flow{
        emit(StateConnetion.loading())
        try {
            val hostApires = hostInterface.getDataDev()
            emit(StateConnetion.success(hostApires))
        }catch (e:IOException){
            emit(StateConnetion.failed(e.message.toString()))
        }

    }
}