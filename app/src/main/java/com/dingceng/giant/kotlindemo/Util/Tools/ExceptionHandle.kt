package com.dingceng.giant.kotlindemo.Util.Tools


import com.google.gson.JsonParseException
import org.json.JSONException
import com.dingceng.giant.kotlindemo.Util.Tools.CodeException
import com.dingceng.giant.kotlindemo.Http.Base.ErrorData
import retrofit2.HttpException
import java.net.ConnectException


/**
 * Created by Administrator on 2018/2/26 0026.
 */
object ExceptionHandle {


    fun exceptionMessage(e: Throwable): ErrorData {
        return if (e is HttpException) {
            ErrorData(0, "网络错误，请重试")
        } else if (e is JsonParseException || e is JSONException) {
            ErrorData(0, "解析错误")
        } else if (e is ConnectException) {
            ErrorData(0, "连接失败，请重试")
        } else if (e is javax.net.ssl.SSLHandshakeException) {
            ErrorData(0, "证书验证失败，请重试")
        } else if (e is CodeException) {
            ErrorData(e.code, e.msg)
        } else {
            ErrorData(0, " 未知错误，请重试")
        }
    }
}