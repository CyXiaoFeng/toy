package com.toys.example;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;

public class ViewView extends WebViewAbstract  {
	WebView webView,webViewO,webViewT,webViewTT;
	public ViewView(Context context) {
		super(context);
		inflate(context, R.layout.lay_view, this);
		String gameUrl = "http://192.168.0.20:9090/game/fighter/index.html";
		webView = (WebView) this.findViewById(R.id.wv_vw_1);
		webViewO = (WebView) this.findViewById(R.id.wv_vw_2);
		webViewT = (WebView) this.findViewById(R.id.wv_vw_3);
		webViewTT = (WebView) this.findViewById(R.id.wv_vw_4);
		webView.getSettings().setJavaScriptEnabled(true);
//		webView.setInitialScale(25);
		webViewO.getSettings().setJavaScriptEnabled(true);
//		webViewO.setInitialScale(25);
		webViewT.getSettings().setJavaScriptEnabled(true);
//		webViewT.setInitialScale(25);
		webViewTT.getSettings().setJavaScriptEnabled(true);
//		webViewTT.setInitialScale(25);
		webView.loadUrl(gameUrl);
		webViewO.loadUrl(gameUrl);
		webViewT.loadUrl(gameUrl);
		webViewTT.loadUrl(gameUrl);
		webView.setWebViewClient(webViewClient);
		webViewO.setWebViewClient(webViewClient);
		webViewT.setWebViewClient(webViewClient);
		webViewTT.setWebViewClient(webViewClient);
	}
	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		if(visibility == View.GONE) {
			webView.destroy();
			webViewO.destroy();
			webViewT.destroy();
			webViewTT.destroy();
			
		}
	}

}
