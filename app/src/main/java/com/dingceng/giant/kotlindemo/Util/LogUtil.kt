package com.dingceng.giant.kotlindemo.Util

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.Logger.addLogAdapter
import java.util.*


object LogUtil {
    init {
        Logger.addLogAdapter(AndroidLogAdapter())
    }

    fun d(msg: Any) {
        Logger.d(msg)
    }

    fun e(msg: String) {
        Logger.e(msg)
    }

    fun w(msg: String) {
        Logger.w(msg)
    }

    fun v(msg: String) {
        Logger.v(msg)
    }

    fun i(msg: String) {
        Logger.i(msg)
    }
    fun json (msg:String){
        Logger.json(msg)

    }

}