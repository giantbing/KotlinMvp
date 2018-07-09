package com.example.administrator.pyx.service

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Build
import android.os.IBinder
import com.example.administrator.pyx.service.AppBroadcastServe.NetType.NET_BROADCAST
import com.example.administrator.pyx.service.AppBroadcastServe.NetType.NET_KEY
import com.vondear.rxtool.RxNetTool

@SuppressLint("Registered")
/**
 * Created by Administrator on 2017/12/18 0018.
 */
class AppBroadcastServe : Service() {


    object NetType {
        val NET_KEY = "netWorkState"

        val NET_BROADCAST = "NetworkServe"
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1) {
            startForeground(1, Notification())
        }
        val intentFilter = IntentFilter()
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(receiver, intentFilter)
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val action = intent!!.action
            if (action == ConnectivityManager.CONNECTIVITY_ACTION) {

                val isNet = RxNetTool.ping()
                val netWorkIntent = Intent(NET_BROADCAST)
                netWorkIntent.putExtra(NET_KEY, isNet)
                sendBroadcast(netWorkIntent)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }


}