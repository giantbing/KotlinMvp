package com.dingceng.giant.kotlindemo.Main

import com.dingceng.giant.kotlindemo.Base.Mvp.BaseView
import com.dingceng.giant.kotlindemo.Http.Bean.WeatherBean

interface MainView : BaseView{
    fun initData(data: WeatherBean)
}