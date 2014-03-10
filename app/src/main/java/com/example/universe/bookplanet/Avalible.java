package com.example.universe.bookplanet;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.example.universe.A_My_Galaxy;
import com.example.universe.R;
import com.example.universe.utils.DBConect;




import android.R.string;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class Avalible extends ListActivity  {
	
	private ProgressDialog pd;


	
	
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_avalible_listplaceholder);
        
        


        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        JSONObject json = DBConect.getJSONfromURL("http://server1.valnir.com/solutionbox/books_read.php");
        
        
        
        try{
        	
        	JSONArray  earthquakes = json.getJSONArray("userlist");
        	
	        for(int i=0;i<earthquakes.length();i++){						
				HashMap<String, String> map = new HashMap<String, String>();
				JSONObject e = earthquakes.getJSONObject(i);
				
				map.put("id",  String.valueOf(i));
	        	map.put("bookid",  e.getString("BookId"));
	        	map.put("name", e.getString("Title"));
	        	map.put("author", e.getString("Author"));
	        	map.put("prise", "Prise: " +  e.getString("Prise"));
	        	map.put("isbn", "ISBN:\n" + e.getString("ISBN"));
	        	map.put("year", "Year:  " + e.getString("Year"));
	        	map.put("edition", e.getString("Edition")+ " Edition" );
	        	map.put("@",  e.getString("Email"));
	        	map.put("trae",  e.getString("Thumbnail"));
	        	map.put("comment", e.getString("Comment"));
	        	map.put("forsale",  e.getString("ForSale"));
	        	map.put("sold", e.getString("Sold"));

	        	mylist.add(map);	
	   
			}		
        }catch(JSONException e)        {
        	 Log.e("log_tag", "Error parsing data "+e.toString());
        }
        
        final ListAdapter adapter = new SimpleAdapter(this, mylist , R.layout.book_avalible, 
                        new String[] { "name", "prise","author" }, 
                        new int[] { R.id.item_title, R.id.item_prise,R.id.item_author });
        
        setListAdapter(adapter);
        
         final ListView lv = getListView();
        lv.setTextFilterEnabled(true);	
        lv.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
        		@SuppressWarnings("unchecked")
				HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
        		Toast.makeText(Avalible.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_SHORT).show(); 
        		Intent intent = new Intent(view.getContext(), com.example.universe.bookplanet.Avalible_detale.class);
        		intent.putExtra("BookId", o.get("role"));
        		intent.putExtra("Title", o.get("name"));
        		intent.putExtra("Author", o.get("author"));
        		intent.putExtra("Prise", o.get("prise"));
        		intent.putExtra("ISBN", o.get("isbn"));
        		intent.putExtra("Year", o.get("year"));
        		intent.putExtra("Edition", o.get("edition"));
        		intent.putExtra("Email", o.get("@"));
        		intent.putExtra("Trade", o.get("trade"));
        		intent.putExtra("Comment", o.get("comment"));
        		intent.putExtra("ForSale", o.get("forsale"));
        		intent.putExtra("Sold", o.get("sold"));

                startActivityForResult(intent, 0);
	    		 
	    		 ;

	    		 
	    		 
        	}
    		});
        
      
        
        
        }
    
    
    
    
    }
        	