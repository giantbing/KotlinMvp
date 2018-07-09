package com.dingceng.giant.kotlindemo.Main

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.widget.DrawableUtils
import android.view.View
import com.dingceng.giant.kotlindemo.Base.BaseAppActivity
import com.dingceng.giant.kotlindemo.Event.ErrorEvent
import com.dingceng.giant.kotlindemo.Http.Bean.WeatherBean
import com.dingceng.giant.kotlindemo.R
import com.dingceng.giant.kotlindemo.Util.ToastUtil
import com.dingceng.giant.kotlindemo.View.WechatDialog
import com.special.ResideMenu.ResideMenu
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import com.special.ResideMenu.ResideMenuItem
import android.view.MotionEvent





class MainActivity : BaseAppActivity(), MainView {

    val resideMenu :ResideMenu by lazy {ResideMenu(this)  }
    override fun clickListener() {
        tvShowModel.setOnClickListener(this)

    }

    override fun viewClick(v: View) {
        when(v.id){
            R.id.tvShowModel -> {
                val wechatDialog = WechatDialog()
                val bundle = Bundle()
                bundle.putString("content", "asdalfhalskfl")
                wechatDialog.arguments = bundle
                wechatDialog.show(supportFragmentManager, "WechatDialog")
                EventBus.getDefault().post(ErrorEvent("asdasdsdfg", 3))
            }
        }
    }

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


     fun initView() {
         resideMenu.attachToActivity(this)
         resideMenu.background = getDrawable(R.drawable.main_side_back)
         val titles = arrayOf("Home", "Profile", "Calendar", "Settings")
         for (title in titles) {
             val item = ResideMenuItem(this)
             item.setTitle(title)
             item.setOnClickListener(this)
             resideMenu.addMenuItem(item, ResideMenu.DIRECTION_LEFT) // or  ResideMenu.DIRECTION_RIGHT
         }
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        return resideMenu.dispatchTouchEvent(ev)
    }
}

