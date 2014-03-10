package com.example.universe.collective;

import com.example.universe.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class UniCollective_detale extends Activity   {
	
	 private TextView username;
	 private TextView title;
	 private TextView date;
	 private TextView post;
	 
	
	 
	 
	 

	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coll_unicollective_detale);
        
        
     	username = (TextView) findViewById(R.id.item_title);
		title = (TextView) findViewById(R.id.item_author);
		date = (TextView) findViewById(R.id.item_prise);
		post = (TextView) findViewById(R.id.item_comment);

		
        
		
		
		Bundle extras = getIntent().getExtras(); 
        if(extras !=null)
        {
        	
        String titleString = extras.getString("UserName");
        username.setText(String.valueOf(titleString));
       	
        String authorString = extras.getString("Title");
       	title.setText(String.valueOf(authorString));
      	
      	String isbnString = extras.getString("Date");
      	date.setText(String.valueOf(isbnString));
      
      	String commentString = extras.getString("Post");
      	post.setText(String.valueOf(commentString));
      	
     
      	
    //  	final LoaderImageView image = new LoaderImageView(this, "http://developer.android.com/images/dialog_buttons.png");
    //  	image.setImageDrawable("http://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png");

        	
    
        
        
   

}


    }}



        	