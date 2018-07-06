package com.dingceng.giant.kotlindemo.Splash

import com.dingceng.giant.kotlindemo.Base.BaseAppActivity
import com.dingceng.giant.kotlindemo.R

class SplashActivity : BaseAppActivity() {
    override fun openEventBus() = false

    override fun getActivityLayout(): Int = R.layout.activity_splash

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
    }

    override fun clickListener() {
    }
}