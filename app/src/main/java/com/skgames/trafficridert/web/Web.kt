package com.skgames.trafficridert.web


import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri

import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.appsflyer.AppsFlyerLib
import com.skgames.trafficridert.AppClass


import org.json.JSONException
import org.json.JSONObject
import java.io.File

import com.skgames.trafficridert.AppClass.Companion.deep
import com.skgames.trafficridert.AppClass.Companion.eus
import com.skgames.trafficridert.AppClass.Companion.instId

import com.skgames.trafficridert.AppClass.Companion.link
import com.skgames.trafficridert.AppClass.Companion.myId
import com.skgames.trafficridert.AppClass.Companion.weopslsamkx
import com.skgames.trafficridert.R
import com.skgames.trafficridert.databinding.ActivityNysjwkkeBinding

import java.io.IOException

class Web : AppCompatActivity() {

    var aspol: ValueCallback<Array<Uri>>? = null
    lateinit var yudfn: WebView
    var eopdlk: String? = null
    lateinit var kvnxcjvjbjasbd: ActivityNysjwkkeBinding
    private val ndsauasadus = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        kvnxcjvjbjasbd = ActivityNysjwkkeBinding.inflate(layoutInflater)
        setContentView(kvnxcjvjbjasbd.root)

        yudfn = kvnxcjvjbjasbd.ioxzk
        Snackbar.make(
            kvnxcjvjbjasbd.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val usudjx = CookieManager.getInstance()
        usudjx.setAcceptCookie(true)
        usudjx.setAcceptThirdPartyCookies(yudfn, true)
        ghjhdfjsjf()
        val apsodldsk: Activity = this
        yudfn.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(vjjkd: WebView, wosp: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(wosp)) {
                        return false
                    }
                    if (ydufuds(wosp)) {

                        val gnvjcxnuhsdasu = Intent(Intent.ACTION_VIEW)
                        gnvjcxnuhsdasu.data = Uri.parse(wosp)
                        startActivity(gnvjcxnuhsdasu)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                vjjkd.loadUrl(wosp)
            }


            override fun onPageFinished(eosp: WebView, kofkodsmkc: String) {
                super.onPageFinished(eosp, kofkodsmkc)
                sdiijsdajiasd(kofkodsmkc)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(apsodldsk, description, Toast.LENGTH_SHORT).show()
            }


        }
        yudfn.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                idjfism: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                chuvxhuhasd: FileChooserParams
            ): Boolean {
                aspol?.onReceiveValue(null)
                aspol = filePathCallback
                var tuifd: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (tuifd!!.resolveActivity(packageManager) != null) {


                    var rstdaasudb: File? = null
                    try {
                        rstdaasudb = isdjjixkkmczmmn()
                        tuifd.putExtra("PhotoPath", eopdlk)
                    } catch (ex: IOException) {

                    }

                    if (rstdaasudb != null) {
                        eopdlk = "file:" + rstdaasudb.absolutePath
                        tuifd.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(rstdaasudb)
                        )
                    } else {
                        tuifd = null
                    }
                }
                val vkcjvd = Intent(Intent.ACTION_GET_CONTENT)
                vkcjvd.addCategory(Intent.CATEGORY_OPENABLE)
                vkcjvd.type = "image/*"
                val nvkcjidfji: Array<Intent?> =
                    tuifd?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val riodkf = Intent(Intent.ACTION_CHOOSER)
                riodkf.putExtra(Intent.EXTRA_INTENT, vkcjvd)
                riodkf.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                riodkf.putExtra(Intent.EXTRA_INITIAL_INTENTS, nvkcjidfji)
                startActivityForResult(
                    riodkf, ndsauasadus
                )
                return true
            }

            @Throws(IOException::class)
            private fun isdjjixkkmczmmn(): File {
                var euijisdfofsd = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!euijisdfofsd.exists()) {
                    euijisdfofsd.mkdirs()
                }

                euijisdfofsd =
                    File(euijisdfofsd.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return euijisdfofsd
            }

        }

        yudfn.loadUrl(nbnvjcnids())
    }




    private var xicix = false
    override fun onBackPressed() {


        if (yudfn.canGoBack()) {
            if (xicix) {
                yudfn.stopLoading()
                yudfn.loadUrl(ablcxdf)
            }
            this.xicix = true
            yudfn.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                xicix = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }




    private fun ghjhdfjsjf() {
        val eidjjsinjcx = yudfn.settings
        eidjjsinjcx.javaScriptEnabled = true
        eidjjsinjcx.displayZoomControls = false
        eidjjsinjcx.setAppCacheEnabled(true)
        eidjjsinjcx.allowContentAccess = true
        eidjjsinjcx.useWideViewPort = true

        eidjjsinjcx.setSupportZoom(true)
        eidjjsinjcx.userAgentString = eidjjsinjcx.userAgentString.replace("; wv", "")
        eidjjsinjcx.loadWithOverviewMode = true
        eidjjsinjcx.pluginState = WebSettings.PluginState.ON

        eidjjsinjcx.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        eidjjsinjcx.javaScriptCanOpenWindowsAutomatically = true
        eidjjsinjcx.setSupportMultipleWindows(false)
        eidjjsinjcx.allowFileAccess = true

        eidjjsinjcx.domStorageEnabled = true

        eidjjsinjcx.builtInZoomControls = true




    }



    override fun onActivityResult(ixcmkxcmks: Int, bkivi: Int, clospdp: Intent?) {
        if (ixcmkxcmks != ndsauasadus || aspol == null) {
            super.onActivityResult(ixcmkxcmks, bkivi, clospdp)
            return
        }
        var fuudshusahu: Array<Uri>? = null

        if (bkivi == AppCompatActivity.RESULT_OK) {
            if (clospdp == null || clospdp.data == null) {
                fuudshusahu = arrayOf(Uri.parse(eopdlk))
            } else {
                val vkicobbkobvo = clospdp.dataString
                if (vkicobbkobvo != null) {
                    fuudshusahu = arrayOf(Uri.parse(vkicobbkobvo))
                }
            }
        }
        aspol?.onReceiveValue(fuudshusahu)
        aspol = null
    }



    private fun ydufuds(xkkckm: String): Boolean {

        val asdujioasdjio = packageManager
        try {

            asdujioasdjio.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }






    @SuppressLint("SuspiciousIndentation")
    private fun nbnvjcnids(): String {

        val uasdhasdojiasd = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

       val sharedlink = getSharedPreferences(AppClass.link, MODE_PRIVATE)
       val sharedMainId = getSharedPreferences(eus, MODE_PRIVATE)
       val sharedMyID = getSharedPreferences(AppClass.myId, MODE_PRIVATE)
       val sharedInstId = getSharedPreferences(AppClass.instId, MODE_PRIVATE)
       val sharedNaming= getSharedPreferences(weopslsamkx, MODE_PRIVATE)
       val sharedDeep= getSharedPreferences(deep, MODE_PRIVATE)


        val sharPre = getSharedPreferences("SHARED_PREF",
            Context.MODE_PRIVATE)

        val pack = "com.skgames.trafficridert"

        val intent = intent
        val str = intent.getStringExtra("WebInt")


        val myTrId = sharedMyID.getString(myId, null)
        val myInstId: String? = sharedInstId.getString(instId, null)
        val cpOne: String? = sharedNaming.getString(weopslsamkx, null)
        val dpOne: String? = sharedDeep.getString(deep, null)
        val mainId: String? = sharedMainId.getString(eus, "null")
        val afId = AppsFlyerLib.getInstance().getAppsFlyerUID(this)
        AppsFlyerLib.getInstance().setCollectAndroidID(true)


        val one = "deviceID="
        val subOne = "sub_id_1="
        val thrhtrhtrhtrht = "ad_id="
        val fofofofofofofofofo = "sub_id_4="
        val fififififififififif = "sub_id_5="
        val sisisisifsisis = "sub_id_6="


        val lololololololo = "naming"
        val trololo = "deeporg"


        val kiokjjlikjhmkij = Build.VERSION.RELEASE

        val linkAB: String? = sharedlink.getString(link, null)

        var aft = ""

        when (str) {
            "MT" -> {
                aft =
                    "$linkAB$one$myTrId&$thrhtrhtrhtrht$myInstId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                sudhhusndajnasdnj(myTrId.toString())
                Log.d("TESTAG", "urururururururur tracker: $aft")
            }
            "deepLink" -> {
                aft ="$linkAB$subOne$dpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$trololo"
                sudhhusndajnasdnj(myTrId.toString())
                Log.d("TESTAG", "urururururururur deep: $aft")
            }
            "campaign" -> {
                aft =
                    "$linkAB$subOne$cpOne&$one$afId&$thrhtrhtrhtrht$mainId&$fofofofofofofofofo$pack&$fififififififififif$kiokjjlikjhmkij&$sisisisifsisis$lololololololo"
                sudhhusndajnasdnj(afId.toString())
                Log.d("TESTAG", "urururururururur apps: $aft")
            }
        }
        return sharPre.getString("SAVED_URL", aft).toString()
    }
    private fun sudhhusndajnasdnj(cixicj: String) {
        OneSignal.setExternalUserId(
            cixicj,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(hjvbnsksf: JSONObject) {
                    try {
                        if (hjvbnsksf.has("push") && hjvbnsksf.getJSONObject("push").has("success")) {
                            val eiokaoksdkodas = hjvbnsksf.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $eiokaoksdkodas"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (hjvbnsksf.has("email") && hjvbnsksf.getJSONObject("email").has("success")) {
                            val bkvico =
                                hjvbnsksf.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $bkvico"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (hjvbnsksf.has("sms") && hjvbnsksf.getJSONObject("sms").has("success")) {
                            val aosdoasasdkoasd = hjvbnsksf.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $aosdoasasdkoasd"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }




    var ablcxdf = ""
    fun sdiijsdajiasd(clvxcov: String?) {
        if (!clvxcov!!.contains("t.me")) {

            if (ablcxdf == "") {
                ablcxdf = getSharedPreferences(
                    "SHARED_PREF",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    clvxcov
                ).toString()

                val sidjasji = getSharedPreferences("SHARED_PREF", AppCompatActivity.MODE_PRIVATE)
                val qposdlkkd = sidjasji.edit()
                qposdlkkd.putString("SAVED_URL", clvxcov)
                qposdlkkd.apply()
            }
        }
    }
}