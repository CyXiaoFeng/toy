package com.toys.example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.toys.sdk.NativeGame;

public class AttemptView extends WebViewAbstract  {
	WebView webView;
	@SuppressLint("SetJavaScriptEnabled") 
	public AttemptView(Context context) {
		super(context);
		inflate(context, R.layout.lay_attempt, this);
		String gameUrl = "http://192.168.0.20:9090/game/fighter/index.html";
		webView = (WebView) this.findViewById(R.id.att_wv);
		webView.setWebViewClient(webViewClient);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl(gameUrl);
		
		
	}
	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		if(visibility == View.GONE)
			webView.destroy();
	}
	
}
