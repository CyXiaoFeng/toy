package com.toys.example;

import com.toys.sdk.NativeGame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;

public abstract class WebViewAbstract extends RelativeLayout {
	WebViewClient webViewClient;
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
				// TODO Auto-generated method stub
				super.onPageFinished(view, url);
				startGame(view);
			}
		};
		
	}
	@SuppressLint("SetJavaScriptEnabled") 
	public void startGame(WebView webview) {
		/*String js = "function checkInit(){" +
			 "if (!window.init)" +
			    "requestAnimationFrame(checkInit); else " + 
			      "window.init(); start();}" +
			       "checkInit();";

		webview.loadUrl("javascript:" + js);*/
//		ngame.initGame(webview);
//		ngame.startGame(this.getContext(),this.getContext().bo);
		
	}

}
