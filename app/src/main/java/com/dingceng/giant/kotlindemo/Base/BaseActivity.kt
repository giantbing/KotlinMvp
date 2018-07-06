package com.dingceng.giant.kotlindemo.Base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.example.administrator.pyx.service.AppBroadcastServe.NetType.NET_BROADCAST
import com.example.administrator.pyx.service.AppBroadcastServe.NetType.NET_KEY

abstract class BaseActivity : AppCompatActivity() {
    var mContext: AppCompatActivity? = null
    private var isOnPause = false
    private var broadcastReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        setNetIncident()
        onStartActivity(savedInstanceState)
    }

    fun getContext(): AppCompatActivity {
        return mContext!!
    }

    fun showdialog() {
        // LoadDialog.show(mContext)
    }

    fun dismissdialog() {
        //LoadDialog.dismiss(mContext)
    }

    override fun onResume() {
        super.onResume()
        isOnPause = false
    }

    override fun onPause() {
        super.onPause()
        isOnPause = true
    }


    protected abstract  fun onStartActivity(bundle: Bundle?)


    private fun setNetIncident() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(p0: Context?, intent: Intent?) {
                intent?.let {
                    val isNet = it.getBooleanExtra(NET_KEY, false)
                    if (!isNet && !isOnPause) networkStateNo() else if (isNet && !isOnPause) networkStateHave()
                }
            }
        }
        registerReceiver()
    }

    private fun registerReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(NET_BROADCAST)
        registerReceiver(broadcastReceiver, intentFilter)
    }


    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcastReceiver)
    }


    protected open fun networkStateHave() {

    }

    protected open fun networkStateNo() {

    }
}