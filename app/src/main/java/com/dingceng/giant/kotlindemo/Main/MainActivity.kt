package com.dingceng.giant.kotlindemo.Main

import android.os.Bundle
import com.blankj.utilcode.util.ActivityUtils
import com.dingceng.giant.kotlindemo.Base.BaseAppActivity
import com.dingceng.giant.kotlindemo.Event.ErrorEvent
import com.dingceng.giant.kotlindemo.Http.Bean.WeatherBean
import com.dingceng.giant.kotlindemo.R
import com.dingceng.giant.kotlindemo.Splash.SplashActivity
import com.dingceng.giant.kotlindemo.Util.LogUtil
import com.dingceng.giant.kotlindemo.Util.ToastUtil
import com.dingceng.giant.kotlindemo.View.WechatDialog
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus

class MainActivity : BaseAppActivity(), MainView {

    override fun initData(data: WeatherBean) {
       ToastUtil.success(this,data.weatherinfo.city)
    }

    private val presenter by lazy { MainPresenter(this,this,this) }
    override fun openEventBus() = false

    override fun getActivityLayout() = R.layout.activity_main

    override fun setActivityTitle() {

    }

    override fun initActivityData() {
        presenter.initData()
        initView()
    }

    override fun clickListener() {
        tvShowModel.setOnClickListener {
            val wechatDialog = WechatDialog()
            val bundle = Bundle()
            bundle.putString("content", "asdalfhalskfl")
            wechatDialog.arguments = bundle
            wechatDialog.show(supportFragmentManager, "WechatDialog")
            EventBus.getDefault().post(ErrorEvent("asdasdsdfg", 3))
           // ActivityUtils.startActivity(SplashActivity::class.java)
        }
    }

     fun initView() {

    }

}

