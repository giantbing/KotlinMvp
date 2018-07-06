package com.dingceng.giant.kotlindemo.Http.Base



import com.blankj.utilcode.util.CacheDiskUtils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import com.dingceng.giant.kotlindemo.Util.Tools.ExceptionHandle

/**
 * Created by Administrator on 2017/12/18 0018.
 */
open abstract class BaseData<T> : Observer<T> {

    private var what = 0
    private val saveInfo by lazy { requestCache() }

    private var disposable: Disposable? = null
    private var observable: Observable<T>? = null


    open fun api(able: Observable<T>): BaseData<T> {
        observable = able
        return this
    }

    open fun setMsg(msg: Int): BaseData<T> {
        what = msg
        return this
    }

    open fun build(): BaseData<T> {
        observable?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())?.subscribe(this)
        return this
    }


    open fun getDisposable(): Disposable? {
        return if (disposable != null) disposable!! else null
    }


    //请求成功
    override fun onNext(data: T) {
        onSucceedRequest(data, what)
    }


    //请求失败
    override fun onError(t: Throwable) {
        if (saveInfo.requestDataCache) {
            getSaveData(t)
        } else {
            setErrorRequest(t)
        }
    }


    override fun onSubscribe(d: Disposable) {
        this.disposable = d
    }


    private fun getSaveData(t: Throwable) {
        var resultBean =  CacheDiskUtils.getInstance().getSerializable(saveInfo.requestDataCacheTag) as T
        if (resultBean != null) {
            onSucceedRequest(resultBean, what)
        } else {
            setErrorRequest(t)
        }
    }


    private fun setErrorRequest(t: Throwable) {
        val errorData = ExceptionHandle.exceptionMessage(t)
        onErrorRequest(errorData.code, errorData.msg, what)
    }

    override fun onComplete() {}

    protected abstract fun requestCache(): SaveInfo

    protected abstract fun onSucceedRequest(data: T, what: Int)

    protected abstract fun onErrorRequest(flag: Int, msg: String, what: Int)

}