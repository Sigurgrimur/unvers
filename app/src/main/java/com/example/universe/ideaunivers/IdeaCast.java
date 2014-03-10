package com.example.universe.ideaunivers;

import android.app.Activity;
import android.os.Bundle;
import android.app.AlertDialog;
import com.example.universe.R;

public class IdeaCast extends Activity 
{
	  public static final String WEB_URI = "http://server1.valnir.com/solutionbox/";
	  AlertDialog.Builder builder;

	  /**
	   * Called when the activity is first created.
	   */
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.idea_ideacast);

	  }
	}
