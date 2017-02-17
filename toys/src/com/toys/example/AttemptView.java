package com.toys.example;

import com.toys.sdk.NativeGame;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

@SuppressLint("JavascriptInterface") 
public class AttemptView extends WebViewAbstract  {
	public WebView webView;
	Context context;
	@SuppressLint("SetJavaScriptEnabled") 
	public AttemptView() {
		super(null);
	}
	@SuppressLint("SetJavaScriptEnabled")
	public AttemptView(Context context) {
		super(context);
		this.context = context;
		inflate(context, R.layout.lay_attempt, this);
		String gameUrl = "http://192.168.0.20:9090/game/fighter/index.html";
		webView = (WebView) this.findViewById(R.id.att_wv);
		webView.setWebViewClient(webViewClient);
		webView.setWebChromeClient(webChromeClient);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
		webView.addJavascriptInterface(this, "android");
		webView.loadUrl(gameUrl);
		
	}
	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		if(visibility == View.GONE) {
			webView.clearHistory();
			webView.clearCache(true);
			webView.destroy();
		}
	}
	
	@Override
	public void startGame(WebView webview) {
		String CONST_JS = "javascript:window.webViewClient={};var viewport=document.getElementsByName(\"viewport\")[0];viewport||(viewport=document.createElement(\"META\"),viewport.name=\"viewport\",document.getElementsByTagName(\"head\")[0].appendChild(viewport)),viewport.content=\"width=device-width,user-scalable=no,minimum-scale=1,maximum-scale=1,initial-scale=1\";var scale=%f,width=document.body.clientWidth*scale;scale=(375>width?.8:414>width?.9:1)/scale,viewport.content=\"width=device-width,user-scalable=no,minimum-scale=\"+scale+\",maximum-scale=\"+scale+\",initial-scale=\"+scale,window.webViewClient.check=function(){for(var e=\"init,start,pause,stop,restart,getScore,getScreenShot,setScreenShot\".split(\",\"),i=0;i<e.length;i++){var t=e[i];if(!window[t])return void requestAnimationFrame(window.webViewClient.check)}window._stop=window.stop,window.stop=function(){%s(null),window._stop(),window.gameOver=1},window.webViewClient.pullScreenShot=function(){var e=window.getScreenShot()||\"\",i=\"{\";i+=\"g:\"+window.gameOver+\",\",i+=\"s:\"+window.getScore()+\",\",i+=\"d:\"+e+\"}\",%s(i)},window.sendData=function(e){%s(e)},window.webViewClient.onReceiveData=window.onReceiveData||function(){},window.createAudio=function(e){\"string\"==typeof e&&(e={src:e});var i={};for(var t in e)i[t]=e[t];return i.play=function(e){void 0==e&&(e=this.loop?-1:1),%s(this.src+\",\"+e)},i.pause=function(){this.stop()},i.stop=function(){},e.autoplay&&i.play(),i},window.init(),window.start(),%s(null)},window.webViewClient.check();";
		CONST_JS = String.format(CONST_JS, 1.0, "window.android.stop","window.android.setScreenShot",
				"window.android.sendData","window.android.playAudio","window.android.ready");
//		webview.loadUrl(CONST_JS);
		NativeGame.initGame(webview);
	}
	@JavascriptInterface
	public void stop() {
		Log.d(TAG, "on stop from js");
	}
	@JavascriptInterface
	public void setScreenShot(String string) {
		Log.d(TAG, "on setScreenShot from js");
		
	}
	@JavascriptInterface
	public void sendData(String string) {
		Log.d(TAG, "on sendData from js");
		
	}
	@JavascriptInterface
	public void playAudio(String name) {
		Log.d(TAG, "on playAudio from js");
		
	}
	@JavascriptInterface
	public void ready(Object object) {
		Log.d(TAG, "on ready from js");
		try {
			webView.post(new Runnable() {
				
				@Override
				public void run() {
					
					webView.loadUrl("javascript:start()");
					
				}
			});
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
