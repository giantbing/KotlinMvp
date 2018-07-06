package com.dingceng.giant.kotlindemo.Util

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.Toast
import es.dmoral.toasty.Toasty

object ToastUtil {

    init {
//        Toasty.Config.getInstance()
//                .setErrorColor() // optional
//                .setInfoColor(@ColorInt int infoColor) // optional
//                .setSuccessColor(@ColorInt int successColor) // optional
//                .setWarningColor(@ColorInt int warningColor) // optional
//                .setTextColor(@ColorInt int textColor) // optional
//                .tintIcon(boolean tintIcon) // optional (apply textColor also to the icon)
//                .setToastTypeface(@NonNull Typeface typeface) // optional
//                .setTextSize(int sizeInSp) // optional
//                .apply(); // required
    }

    fun error(context: Context, msg: String, isshowIco: Boolean = true, time: Int = Toast.LENGTH_SHORT) {
        Toasty.error(context, msg, time, isshowIco).show()
    }

    fun success(context: Context, msg: String, isshowIco: Boolean = true, time: Int = Toast.LENGTH_SHORT) {
        Toasty.success(context, msg, time, isshowIco).show()
    }

    fun info(context: Context, msg: String, isshowIco: Boolean = true, time: Int = Toast.LENGTH_SHORT) {
        Toasty.info(context, msg, time, isshowIco).show()
    }

    fun normal(context: Context, msg: String, isshowIco: Boolean = false, time: Int = Toast.LENGTH_SHORT, iconDrawable: Drawable? = null) {
        Toasty.normal(context, msg, time, iconDrawable, isshowIco)
    }

    fun custom(context: Context, msg: String, isshowIco: Boolean = false, tintColor: Int, shouldTint: Boolean = true, time: Int = Toast.LENGTH_SHORT, iconDrawable: Drawable? = null) {
        Toasty.custom(context, msg, iconDrawable, tintColor, time, isshowIco,
                shouldTint).show()
    }

}