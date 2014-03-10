package com.example.universe.utils;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

public class UniCollectiveBrain {
	
	
	@SuppressWarnings("unused")
	public static ArrayList<HashMap<String, String>> getUniCollectiveData() {
		
		
		
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        if (mylist.isEmpty()){
        	
        JSONObject json = DBConect.getJSONfromURL("http://server1.valnir.com/solutionbox/Collective_read.php");

        
    try{
        	
        	JSONArray  earthquakes = json.getJSONArray("books");
        	
	        for(int i=0;i<earthquakes.length();i++){						
				HashMap<String, String> map = new HashMap<String, String>();
				JSONObject e = earthquakes.getJSONObject(i);
				
				map.put("id",  String.valueOf(i));
	        	map.put("calid",  e.getString("ColId"));
	        	map.put("date", e.getString("Date"));
	        	map.put("username", e.getString("UserName"));
	        	map.put("title",  e.getString("Title"));
	        	map.put("state",  e.getString("State"));
	        	map.put("post",  e.getString("Post"));
	        	
	        

	        	mylist.add(map);	
	        
			}		
        }catch(JSONException e)        {
        	 Log.e("log_tag", "Error parsing data "+e.toString());
        }
        
return mylist;

        }
        else{
        	return mylist;
	}}

	
	
	
}
