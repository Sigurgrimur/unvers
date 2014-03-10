package com.example.universe.utils;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;

/**
 * Cantona
 * Copyright (c) 2011 by Stokkur Software ehf.
 * ALL RIGHTS RESERVED
 * <p/>
 * Date: 7.5.2011 23:46
 * Coded by: venni
 */
public class UrlBuilder
{
  public static BookBrain preparClient(BookBrain client, Context context)
	{
		PackageInfo pInfo = null;
		try
		{
			pInfo = context.getPackageManager().getPackageInfo("com.example.universe", PackageManager.GET_META_DATA);
			client.addParam("version", pInfo.versionName + "." + pInfo.versionCode);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}

		return client;
	}
}
