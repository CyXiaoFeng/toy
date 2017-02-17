package com.toys.sdk;

import android.content.Context;
import android.webkit.WebView;

public class NativeGame {
	static {
		System.loadLibrary("toys");
	}
	public native void start();
	public native void init();
	public static native void initGame(WebView webView);
	public static native void startGame(Context con);
}
