package com.dingceng.giant.kotlindemo

import android.app.Application
import com.dingceng.giant.kotlindemo.Event.ErrorEvent
import com.dingceng.giant.kotlindemo.Util.ToastUtil
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class Myapp() : Application() {

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
    }

    override fun onTerminate() {
        super.onTerminate()
        EventBus.getDefault().unregister(this)
    }

    //处理所有网络错误显示toast
    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErroCatch(event:ErrorEvent){
        ToastUtil.error(this,event.msg)
    }
}