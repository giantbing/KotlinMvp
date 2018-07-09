package com.dingceng.giant.kotlindemo.View

import android.content.Context
import android.widget.FrameLayout
import android.view.animation.AnimationUtils
import android.os.Handler
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import com.dingceng.giant.kotlindemo.R
import kotlinx.android.synthetic.main.scaleimageview.view.*


class AutoImageView : FrameLayout {


    internal var resId: Int = 0

    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        //导入布局
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet) {
        LayoutInflater.from(context).inflate(R.layout.scaleimageview, this)


        //获得这个控件对应的属性。
        val a = getContext().obtainStyledAttributes(attrs, R.styleable.RxAutoImageView)

        try {
            //获得属性值
            resId = a.getResourceId(R.styleable.RxAutoImageView_ImageSrc, 0)
        } finally {
            //回收这个对象
            a.recycle()
        }

        if (resId != 0) {
            imgBackground!!.setImageResource(resId)
        }

        Handler().postDelayed({
            val animation = AnimationUtils.loadAnimation(context, R.anim.translatey_anim)
            imgBackground!!.startAnimation(animation)
        }, 200)
    }
}