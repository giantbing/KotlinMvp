package com.dingceng.giant.kotlindemo.Http.Bean


data class WeatherBean(
    val weatherinfo: Weatherinfo
)

data class Weatherinfo(
    val city: String,
    val cityid: String,
    val temp: String,
    val WD: String,
    val WS: String,
    val SD: String,
    val WSE: String,
    val time: String,
    val isRadar: String,
    val Radar: String,
    val njd: String,
    val qy: String
)