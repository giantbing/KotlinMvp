package com.example.administrator.pyx.base

import android.view.View
import pyx.pyx.project.app.utils.tool.FastDoubleClick

/**
 * Created by Administrator on 2018/1/26 0026.
 */
interface BaseClickListener : View.OnClickListener {

    override fun onClick(v: View?) {
        if (!FastDoubleClick.isFastDoubleClick()) viewClick(v!!)
    }

    fun viewClick(v: View)
}