package com.toys.example;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.toys.sdk.NativeGame;

public class MainActivity extends Activity implements OnClickListener {

    @SuppressLint("NewApi") @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);    
       getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);
       setContentView(R.layout.activity_main);
       PlaceholderFragment pf = new PlaceholderFragment();
      
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, pf, "frg")
                    .commit();
        }
    }

    @SuppressLint({ "NewApi", "ShowToast" }) 
    @Override
    public void onClick(View arg0) {
    	 android.app.FragmentManager frm = getFragmentManager();
         android.app.Fragment frg = frm.findFragmentByTag("frg");
         View v = frg.getView().findViewById(R.id.container);
         Toast.makeText(this, "container->" + (v == null), Toast.LENGTH_LONG).show();
         v = frg.getView().findViewById(R.id.att_wv);
//         Toast.makeText(this, "webview->" + (v == null), Toast.LENGTH_LONG).show();
//         ng.initGame((WebView) v);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    static RelativeLayout layContainer = null;
    static NativeGame ng = new NativeGame();
    /**
     * A placeholder fragment containing a simple view.
     */
    @SuppressLint("NewApi") 
    public static class PlaceholderFragment extends Fragment {
    	
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            layContainer = (RelativeLayout) rootView.findViewById(R.id.container);
            rootView.findViewById(R.id.hello).setOnClickListener((android.view.View.OnClickListener) this.getActivity());
            ng.init();
            ng.start();
            return rootView;
        }
    }

    public void switching(final View view) {
    	layContainer.removeAllViews();
    	layContainer.post(new Runnable() {
			@Override
			public void run() {
				WebViewAbstract webViewabs = null;
		    	webViewabs = view.getId() == R.id.attempt?
		    			new AttemptView(MainActivity.this):
		    				view.getId() == R.id.pk?new PKView(MainActivity.this):
		    					view.getId() == R.id.view?new ViewView(MainActivity.this):
		    						null;
		    	if(webViewabs != null)
		    		layContainer.addView(webViewabs);
		    	
		    	navigator(view, webViewabs);
				
			}
		});
    	
    }
    @SuppressWarnings("static-access")
	public void navigator(View buttonView, WebViewAbstract webViewAbstract) {
    	if(buttonView.getId() == R.id.attempt) {
    		ng.initGame((WebView) webViewAbstract.findViewById(R.id.att_wv));
    	}
//    	webview.loadUrl("http://192.168.0.20:9090/game/fighter/index.html");
    }

}
