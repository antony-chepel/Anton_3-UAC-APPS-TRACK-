package com.skgames.trafficridert

import android.app.Application
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import dagger.hilt.android.HiltAndroidApp
import java.util.*

@HiltAndroidApp
class AppClass : Application() {
    companion object {
        const val oneSignal = "abcf9f6f-4a8b-4587-8844-b7ae50727876"
        var eus: String? = ""
        var link = "link"
        const val appsChecker = "appsChecker"
        var awospdlsldxkkzc: String? = "instID"
        const val tracker = "60804361398653608560"
        var kdoslx: String? = "myID"
        var weopslsamkx: String? = "c11"


    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(oneSignal)

        val iowkd = getSharedPreferences("PREFS_NAME", 0)
        val sharedInstId = getSharedPreferences(awospdlsldxkkzc, MODE_PRIVATE)
        val sharedMyID = getSharedPreferences(kdoslx, MODE_PRIVATE)
        val apsol = MyTracker.getTrackerParams()
        val njicv = MyTracker.getTrackerConfig()
        val yuirkkodfmovx = MyTracker.getInstanceId(this)
        njicv.isTrackingLaunchEnabled = true
        if (iowkd.getBoolean("my_first_time", true)) {
            val hjmbv = UUID.randomUUID().toString()
            apsol.setCustomUserId(hjmbv)
            sharedMyID.edit().putString(kdoslx,hjmbv).apply()
            sharedInstId.edit().putString(awospdlsldxkkzc,yuirkkodfmovx).apply()
            iowkd.edit().putBoolean("my_first_time", false).apply()

        } else {
            val wosplx = sharedMyID.getString(kdoslx,"null")
            apsol.setCustomUserId(wosplx)
        }
        MyTracker.initTracker(tracker, this)

    }
}