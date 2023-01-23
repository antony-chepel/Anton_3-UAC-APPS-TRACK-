package com.skgames.trafficridert

import android.app.Application
import android.content.Context
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
class AppClass : Application() {
    companion object {
        const val oneSignal = "abcf9f6f-4a8b-4587-8844-b7ae50727876"
        var eus: String? = "main_id"
        var link = "link"
        const val appsChecker = "appsChecker"
        val myId: String = "myID"
        var instId: String? = "instID"
        var deep: String? = "d11"
        var weopslsamkx: String? = "c11"


    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(oneSignal)

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(oneSignal)

        val oicjicjxd = getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        val tifjjdfijidf = getSharedPreferences("PREFS_NAME", 0)

        val oxkjicjxiz = MyTracker.getTrackerParams()
        val psosloxkczjixjiz = MyTracker.getTrackerConfig()
        val tiuhdsjifijsdfji = MyTracker.getInstanceId(this)
        psosloxkczjixjiz.isTrackingLaunchEnabled = true
        val siajddiasj = UUID.randomUUID().toString()

        if (tifjjdfijidf.getBoolean("my_first_time", true)) {
            oxkjicjxiz.setCustomUserId(siajddiasj)
            oicjicjxd.edit().putString(myId, siajddiasj).apply()
            oicjicjxd.edit().putString(instId, tiuhdsjifijsdfji).apply()
            tifjjdfijidf.edit().putBoolean("my_first_time", false).apply()
        } else {
            val mcxivjivjxcjixcv = oicjicjxd.getString(myId, siajddiasj)
            oxkjicjxiz.setCustomUserId(mcxivjivjxcjixcv)
        }
        MyTracker.initTracker("68730396266309548180", this)
    }
}