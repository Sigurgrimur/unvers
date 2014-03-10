package com.example.universe.bookplanet;

import com.example.universe.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Avalible_detale extends Activity   {
	
	private Button button11;
	 private TextView book_title;
	 private TextView book_author;
	 private TextView book_prise;
	 private TextView book_isbn;
	 private TextView book_year;
	 private TextView book_comment;
	 private TextView book_edition;
	 
	
	 
	 
	 

	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_avalible_detale);
        
        
     	book_title = (TextView) findViewById(R.id.item_title);
		book_author = (TextView) findViewById(R.id.item_author);
		book_prise = (TextView) findViewById(R.id.item_prise);
		book_isbn = (TextView) findViewById(R.id.item_isbn);
		book_year = (TextView) findViewById(R.id.item_year);
		book_comment = (TextView) findViewById(R.id.item_comment);
		book_edition = (TextView) findViewById(R.id.item_edition);
		button11 = (Button)findViewById(R.id.button_email);
        
		
		
		Bundle extras = getIntent().getExtras(); 
        if(extras !=null)
        {
        	
        	String titleString = extras.getString("Title");
       	 book_title.setText(String.valueOf(titleString));
       	String authorString = extras.getString("Author");
      	 book_author.setText(String.valueOf(authorString));
      	String priseString = extras.getString("Prise");
      	 book_prise.setText(String.valueOf(priseString));
      	String isbnString = extras.getString("ISBN");
      	 book_isbn.setText(String.valueOf(isbnString));
      	String yearString = extras.getString("Year");
      	 book_year.setText(String.valueOf(yearString));
      	String commentString = extras.getString("Comment");
      	 book_comment.setText(String.valueOf(commentString));
      	String editionString = extras.getString("Edition");
      	book_edition.setText(String.valueOf(editionString));
      	//String thumbnail = extras.getString("Thumbnail");
      	
    //  	final LoaderImageView image = new LoaderImageView(this, "http://developer.android.com/images/dialog_buttons.png");
    //  	image.setImageDrawable("http://java.sogeti.nl/JavaBlog/wp-content/uploads/2009/04/android_icon_256.png");

        	
    
        
        
    button11.setOnClickListener(new OnClickListener() {
   	 public void onClick(View view) {
 

   	   Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND); 
   	 Bundle extras = getIntent().getExtras(); 
     if(extras !=null)
     {
     	 
     	String mail= extras.getString("Email");
     String subject= extras.getString("Title");
    // String subjects[] = { subject}; 
		String aEmailList[] = { mail  }; 
		 
    	  emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
    	  emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
    	  emailIntent.setType("plain/text"); 
    	  emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "\n\nSent from UNIVerse.");
    	  startActivity(emailIntent); 
      }}
   
    
    });

}


    }}



        	