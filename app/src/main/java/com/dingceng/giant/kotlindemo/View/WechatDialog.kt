package com.dingceng.giant.kotlindemo.View

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.*
import com.dingceng.giant.kotlindemo.R
import kotlinx.android.synthetic.main.wechat_dialog.*
import android.content.ClipData
import android.content.ClipboardManager
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatDialogFragment
import android.text.TextUtils
import android.widget.Toast
import com.blankj.utilcode.util.BarUtils
import com.dingceng.giant.kotlindemo.Base.BaseDialogFragment
import com.dingceng.giant.kotlindemo.Consts


class WechatDialog : BaseDialogFragment() {
    override fun getLayout(): Int = R.layout.wechat_dialog

    override fun initData(bundle: Bundle?) {
        BarUtils.setStatusBarAlpha(activity as Activity,0)
        val content = arguments?.get("content")
        (content as? String)?.let {
            setData(it)
        }
    }

    override fun clickLisener() {
        tvWechatCacle.setOnClickListener {
            dialog.dismiss()
        }
        tvWechatCopy.setOnClickListener {
            val cm = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if (!TextUtils.isEmpty(tvWechatContent.text)) {
                val mClipData = ClipData.newPlainText("Label", tvWechatContent.text)
                // 将ClipData内容放到系统剪贴板里。
                cm.primaryClip = mClipData
                Toast.makeText(activity, "成功复制到粘贴板！", Toast.LENGTH_SHORT).show()
                dismiss()
            } else {
                Toast.makeText(activity, "获取失败", Toast.LENGTH_SHORT).show()
            }

        }
    }




    fun setData(content: String) {
        tvWechatContent.text = content

    }

    override fun initView() {
    }

}