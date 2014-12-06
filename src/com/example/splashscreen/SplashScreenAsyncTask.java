package com.example.splashscreen;

import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class SplashScreenAsyncTask extends AsyncTask<URL, Integer, String> {
	
	// String for LogCat documentation
	private final static String TAG = "SplashScreen-AsyncTask";
	private Activity mParentActivity;
	
	private int waitnumber = 10;
	private String doInReturn = "ok";
	private ProgressBar spinTask;
	
	public SplashScreenAsyncTask(Activity parentActivity, ProgressBar bar) {
		// TODO Auto-generated constructor stub
		super();
		Log.i(TAG, "SplashScreenAsyncTask().");
		mParentActivity = parentActivity;
		spinTask = bar;
	}
	
	@Override
	protected String doInBackground(URL... params) {
		// TODO Auto-generated method stub
		int progress = 0;
		while(progress<=waitnumber) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			progress++;
		}
		return doInReturn;
	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		Log.i(TAG, "onPreExecute().");
		spinTask.setVisibility(View.VISIBLE);
	}
	
	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}
	
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		Log.i(TAG, "onPostExecute().");
		spinTask.setVisibility(View.GONE);
		Intent intent = new Intent();
		intent.setClass(mParentActivity, MainActivity.class);
		mParentActivity.startActivity(intent);
	}
}
