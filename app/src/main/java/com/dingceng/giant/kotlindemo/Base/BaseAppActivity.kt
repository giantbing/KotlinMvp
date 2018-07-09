package com.dingceng.giant.kotlindemo.Base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.example.administrator.pyx.base.BaseClickListener
import com.vondear.rxtool.RxBarTool
import org.greenrobot.eventbus.EventBus

abstract class BaseAppActivity: BaseActivity() , BaseClickListener {

    override fun onStartActivity(bundle: Bundle?) {
        setContentView(getActivityLayout())
        setTitleColor()
        openActivityEventBus()
        setActivityTitle()
        initActivityData()
        clickListener()
    }

    protected abstract fun openEventBus(): Boolean

    protected abstract fun getActivityLayout(): Int

    protected abstract fun setActivityTitle()

    protected abstract fun initActivityData()

    protected abstract fun clickListener()


    private fun openActivityEventBus() {
        if (openEventBus()) {
            EventBus.getDefault().register(this)
        }
    }

    private fun closeActivityEventBus() {
        if (!openEventBus()) {
            EventBus.getDefault().unregister(this)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        closeActivityEventBus()
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            RxBarTool.setTransparentStatusBar(this)
        }
    }

    private fun setTitleColor() {
        RxBarTool.setTransparentStatusBar(this)
    }
}