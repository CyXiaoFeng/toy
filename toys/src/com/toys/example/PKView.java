package com.toys.example;

import android.content.Context;
import android.view.View;
import android.webkit.WebSettings.LayoutAlgorithm;
import android.webkit.WebView;

public class PKView extends WebViewAbstract  {
	WebView webViewMaster,webViewOne,webViewTwo,webViewThree;
	public PKView(Context context) {
		super(context);
		inflate(context, R.layout.lay_pk, this);
		String gameUrl = "http://192.168.0.20:9090/game/fighter/index.html";
		webViewMaster = (WebView) this.findViewById(R.id.wv_pk_0);
		webViewOne = (WebView) this.findViewById(R.id.wv_pk_1);
		webViewTwo = (WebView) this.findViewById(R.id.wv_pk_2);
		webViewThree = (WebView) this.findViewById(R.id.wv_pk_3);
		webViewMaster.loadUrl(gameUrl);
		webViewOne.loadUrl(gameUrl);
		webViewTwo.loadUrl(gameUrl);
		webViewThree.loadUrl(gameUrl);
		webViewMaster.getSettings().setJavaScriptEnabled(true);
		webViewMaster.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webViewMaster.getSettings().setLoadWithOverviewMode(true);
		webViewOne.setInitialScale(100);
		webViewOne.getSettings().setJavaScriptEnabled(true);
		webViewOne.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webViewOne.getSettings().setLoadWithOverviewMode(true);
		webViewTwo.setInitialScale(100);
		webViewTwo.getSettings().setJavaScriptEnabled(true);
		webViewTwo.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webViewTwo.getSettings().setLoadWithOverviewMode(true);
		webViewThree.setInitialScale(100);
		webViewThree.getSettings().setJavaScriptEnabled(true);
		webViewThree.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);
		webViewThree.getSettings().setLoadWithOverviewMode(true);
		webViewMaster.setWebViewClient(webViewClient);
		webViewOne.setWebViewClient(webViewClient);
		webViewTwo.setWebViewClient(webViewClient);
		webViewThree.setWebViewClient(webViewClient);
	}

	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		if(visibility == View.GONE) {
			webViewMaster.destroy();
			webViewOne.destroy();
			webViewTwo.destroy();
			webViewThree.destroy();
		}
	}
}
