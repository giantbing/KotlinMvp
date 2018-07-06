package com.dingceng.giant.kotlindemo.Main

import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import com.dingceng.giant.kotlindemo.Base.Mvp.BasePresenter
import com.dingceng.giant.kotlindemo.Event.ErrorEvent
import com.dingceng.giant.kotlindemo.Http.Bean.WeatherBean
import com.dingceng.giant.kotlindemo.Http.HttpClient
import io.reactivex.disposables.Disposable
import org.greenrobot.eventbus.EventBus
import java.util.ArrayList

class MainPresenter(owner: LifecycleOwner, val view:MainView, val context: Context) : BasePresenter(owner, view, context),WheatherDataface {

    override fun initData() {
        WheatherBeanData(this).api( HttpClient.retrofit().loadWeather("101190201")).build()

    }


    override fun onDataSuccess(data: WeatherBean) {
        view.initData(data)
    }

    override fun onErrorOccurred(msg: String) {
        EventBus.getDefault().post(ErrorEvent(msg,0))
    }


    override fun addDisposableList(list: ArrayList<Disposable>) {
    }


    override fun presenterDestroy() {
    }
}