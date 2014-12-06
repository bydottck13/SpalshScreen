package com.example.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ProgressBar;

public class SplashScreenActivity extends Activity {
	
	// String for LogCat documentation
	private final static String TAG = "SplashScreen-SplashScreenActivity";
	private ProgressBar spinbar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splashscreen);
		Log.i(TAG, "onCreate().");
		
		spinbar = (ProgressBar) findViewById(R.id.progressBar1);
		spinbar.setVisibility(View.GONE);
		new SplashScreenAsyncTask(this, spinbar).execute();
		
	}
}
