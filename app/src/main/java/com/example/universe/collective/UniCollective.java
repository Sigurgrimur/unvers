package com.example.universe.collective;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import com.example.universe.R;
import com.example.universe.utils.UniCollectiveBrain;


public class UniCollective extends ListActivity {

	
	 /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
	   super.onCreate(savedInstanceState);
      setContentView(R.layout.coll_unicollective_listplaceholder);

      ArrayList<HashMap<String, String>>   preview = UniCollectiveBrain.getUniCollectiveData();

  final ListAdapter adapter = new SimpleAdapter(this, preview , R.layout.coll_uni_collective, 
          new String[] { "username", "date","title" }, 
          new int[] { R.id.item_title, R.id.item_prise,R.id.item_author });

setListAdapter(adapter);

final ListView lv = getListView();
lv.setTextFilterEnabled(true);	
lv.setOnItemClickListener(new OnItemClickListener() {
public void onItemClick(AdapterView<?> parent, View view, int position, long id) {        		
	@SuppressWarnings("unchecked")
	HashMap<String, String> o = (HashMap<String, String>) lv.getItemAtPosition(position);	        		
	Toast.makeText(UniCollective.this, "ID '" + o.get("id") + "' was clicked.", Toast.LENGTH_SHORT).show(); 
	Intent intent = new Intent(view.getContext(), com.example.universe.collective.UniCollective_detale.class);
	intent.putExtra("UserName", o.get("username"));
	intent.putExtra("Title", o.get("title"));
	intent.putExtra("Post", o.get("post"));
	intent.putExtra("Prise", o.get("state"));
	intent.putExtra("ColId", o.get("colid"));
	intent.putExtra("Date", o.get("date"));


  startActivityForResult(intent, 0);
	 
	 ;

	 
	 
}
});
  
  
  }}