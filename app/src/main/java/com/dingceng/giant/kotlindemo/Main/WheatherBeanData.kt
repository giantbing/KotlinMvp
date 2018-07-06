package com.dingceng.giant.kotlindemo.Main

import com.dingceng.giant.kotlindemo.Http.Base.BaseData
import com.dingceng.giant.kotlindemo.Http.Base.SaveInfo
import com.dingceng.giant.kotlindemo.Http.Bean.WeatherBean

class WheatherBeanData(private val face:WheatherDataface) : BaseData<WeatherBean>() {
    override fun requestCache(): SaveInfo = SaveInfo(false, javaClass.name)

    override fun onSucceedRequest(data: WeatherBean, what: Int) {
        face.onDataSuccess(data)
    }

    override fun onErrorRequest(flag: Int, msg: String, what: Int) {
       face.onErrorOccurred(msg)
    }

}