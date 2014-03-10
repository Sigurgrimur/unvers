package com.example.universe.resturant;

//import com.example.universe.B_thoughts;
import com.example.universe.R;



import android.app.Activity;
//import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
//import android.view.View;
//import android.widget.Button;



public class Offers extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rest_offers);
		
		WebView myWebView = (WebView) findViewById(R.id.webview);
		myWebView.loadUrl("http://bar2lin.dk/menuer/frokostmenu.html");
		//myWebView.setInitialScale(1);
		myWebView.getSettings().setBuiltInZoomControls(true);
	}

}
