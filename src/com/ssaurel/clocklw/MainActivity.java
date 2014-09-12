package com.ssaurel.clocklw;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * Main Activity to set clock live wallpaper.
 * 
 * @author sylsau - sylvain.saurel@gmail.com - http://www.ssaurel.com
 * 
 */
public class MainActivity extends Activity {

	public static final String YOUTUBE_ID = "JrqN83cVHRU";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void setClockLw(View v) {
		Intent intent = new Intent(
				WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER);
		intent.putExtra(WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
				new ComponentName(this, ClockWallpaperService.class));
		startActivity(intent);
	}

	public void showTutorial(View v) {
		try {
			Intent intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("vnd.youtube:" + YOUTUBE_ID));
			startActivity(intent);
		} catch (ActivityNotFoundException ex) {
			Intent intent = new Intent(Intent.ACTION_VIEW,
					Uri.parse("http://www.youtube.com/watch?v=" + YOUTUBE_ID));
			startActivity(intent);
		}
	}

	public void showOtherApps(View v) {
		Intent intent = new Intent(Intent.ACTION_VIEW)
				.setData(Uri
						.parse("https://play.google.com/store/apps/developer?id=Sylvain+Saurel"));
		startActivity(intent);
	}

}
