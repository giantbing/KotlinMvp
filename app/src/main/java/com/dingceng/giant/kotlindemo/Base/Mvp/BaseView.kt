package com.dingceng.giant.kotlindemo.Base.Mvp

import android.content.Context

/**
 * Created by Administrator on 2017/12/18 0018.
 * 基础view接口
 */
interface BaseView {

    fun showLoading(context: Context) {
       // LoadDialog.show(context)
        TODO()
    }

    fun dismissLoading(context: Context) {
        //LoadDialog.dismiss(context)
    }


}