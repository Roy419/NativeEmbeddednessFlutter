package com.taoweiji.flutter.flutter_platform_view

import android.content.Context
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class AndroidTextViewFactory constructor(binaryMessenger: BinaryMessenger) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    var binaryMessenger:BinaryMessenger;
    init {
        this.binaryMessenger = binaryMessenger
    }
    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        val androidTextView = AndroidTextView(context,binaryMessenger )
        androidTextView.contentView.id = viewId
        val params = args?.let { args as Map<*, *> }
        val text = params?.get("text") as CharSequence?
        text?.let {
            androidTextView.contentView.text = it
        }
        return androidTextView
    }
}