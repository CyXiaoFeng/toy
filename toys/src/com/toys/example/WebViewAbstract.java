package com.toys.example;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

import com.toys.sdk.NativeGame;

public abstract class WebViewAbstract extends RelativeLayout {
	String TAG = "WebViewAbstract";
	WebViewClient webViewClient;
	WebChromeClient webChromeClient;
	NativeGame ngame = new NativeGame();
	public WebViewAbstract(Context context) {
		super(context);
		webViewClient = new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			};
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
				startGame(view);
			}
		};
		webChromeClient = new WebChromeClient() {
			@Override
			public boolean onJsAlert(WebView view, String url, String message,
					JsResult result) {
				result.confirm();
				return true;
			}
		};
	}
	public abstract void startGame(WebView webview);
	
}
