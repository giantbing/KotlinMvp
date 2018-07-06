package com.dingceng.giant.kotlindemo.View

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
import com.dingceng.giant.kotlindemo.Consts


class WechatDialog : AppCompatDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val window = dialog.window
        window.requestFeature(Window.FEATURE_NO_TITLE)
        window.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return inflater.inflate(R.layout.wechat_dialog, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val content = arguments?.get("content")
        (content as? String)?.let {
            setData(it)
        }
        initView()
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dialog.window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT)
    }

    fun setData(content: String) {
        tvWechatContent.text = content

    }

    fun initView() {
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
                dialog.dismiss()
            } else {
                Toast.makeText(activity, "获取失败", Toast.LENGTH_SHORT).show()
            }

        }
    }

}