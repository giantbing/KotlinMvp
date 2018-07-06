package com.dingceng.giant.kotlindemo.Base

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import org.greenrobot.eventbus.EventBus

abstract class BaseAppActivity: BaseActivity() {

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


    private fun setTitleColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = resources.getColor(android.R.color.white)
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }
}