package com.dingceng.giant.kotlindemo.Base.Mvp

interface BaseDataFace<T> {
    fun onDataSuccess(data: T)
    fun onErrorOccurred(msg:String)
}