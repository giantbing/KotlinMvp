package com.dingceng.giant.kotlindemo.Http

import com.dingceng.giant.kotlindemo.Http.Bean.WeatherBean
import io.reactivex.Flowable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

//http://www.weather.com.cn/adat/sk/101190201.html
interface HttpApi {
    companion object {
        val BASEURL = "http://www.weather.com.cn/"
    }

    @GET("adat/sk/{cityId}.html")
    fun loadWeather(@Path("cityId")cityId:String):Observable<WeatherBean>
}