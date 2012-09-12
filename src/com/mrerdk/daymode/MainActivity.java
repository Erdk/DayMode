package com.mrerdk.daymode;

import android.os.Bundle;
import android.provider.Settings;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// read the airplane mode setting
		boolean isEnabled = Settings.System.getInt(getContentResolver(),
				Settings.System.AIRPLANE_MODE_ON, 0) == 1;

		if (isEnabled) {
			// toggle airplane mode
			Settings.System.putInt(getContentResolver(),
					Settings.System.AIRPLANE_MODE_ON, 0);
		}

		// Post an intent to reload
		Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
		intent.putExtra("state", !isEnabled);
		sendBroadcast(intent);
		Toast.makeText(getApplicationContext(), "Day mode activated", Toast.LENGTH_LONG).show();
		finish();
	}
}
