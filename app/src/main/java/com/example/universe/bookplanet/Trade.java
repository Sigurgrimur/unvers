package com.example.universe.bookplanet;



import com.example.universe.R;
import com.example.universe.utils.RequestMethod;
import com.example.universe.utils.BookBrain;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class Trade extends Activity implements  OnClickListener, Runnable{
	
	  public static final String WEB_URI = "http://server1.valnir.com/solutionbox/";
	  
	  private RadioButton radio0;
	  private RadioButton radio1;
	  private CheckBox checkBox1;
	  private Button sendButton;
	  private TextView booktitle;
	  private TextView textView18;
	  private TextView textView20;
	  private TextView textView16;
	  private TextView textView14;
	  private TextView textView12;
	  private TextView textView10;
	  private TextView textView06;
	  private ProgressDialog pd;
	  AlertDialog.Builder builder;
	  AlertDialog.Builder buildername;
	  AlertDialog.Builder builderauthor;
	  AlertDialog.Builder builderisbn;
	  AlertDialog.Builder builderyear;
	  AlertDialog.Builder builderedition;
	  AlertDialog.Builder builderemail;
	  AlertDialog.Builder builderprise;
	  AlertDialog.Builder buildercomment;


	  /**
	   * Called when the activity is first created.
	   */
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.book_trade);

	 // I now have all my UI in java memory
	    builder = new AlertDialog.Builder(this);
	    buildername = new AlertDialog.Builder(this);
	    builderauthor = new AlertDialog.Builder(this);
	    builderisbn = new AlertDialog.Builder(this);
	    builderyear = new AlertDialog.Builder(this);
	    builderedition = new AlertDialog.Builder(this);
	    builderemail = new AlertDialog.Builder(this);
	    builderprise = new AlertDialog.Builder(this);
	    buildercomment = new AlertDialog.Builder(this);
	    
	    sendButton = (Button) findViewById(R.id.btn_send);
	    checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
	    radio0 = (RadioButton) findViewById(R.id.radio0);
	    radio1 =(RadioButton) findViewById (R.id.radio1);
	    
	    booktitle = (TextView) findViewById(R.id.booktitle);
	    textView18=(TextView) findViewById(R.id.TextView18);
	    textView20=(TextView) findViewById(R.id.TextView20);
	    textView16=(TextView) findViewById(R.id.TextView16);
	    textView14=(TextView) findViewById(R.id.TextView14);
	    textView12=(TextView) findViewById(R.id.TextView12);
	    textView10=(TextView) findViewById(R.id.TextView10);
	    textView06=(TextView) findViewById(R.id.TextView06);

	    
	    
	 // Define  listeners
	    booktitle.setOnClickListener(this);
	    textView18.setOnClickListener(this);
	    textView20.setOnClickListener(this);
	    textView16.setOnClickListener(this);
	    textView14.setOnClickListener(this);
	    textView12.setOnClickListener(this);
	    textView10.setOnClickListener(this);
	    textView06.setOnClickListener(this);
	    sendButton.setOnClickListener(this);

  }
	  
        
        public void onClick(View src) {
			switch(src.getId()){
			case R.id.booktitle:
				final EditText bookname = new EditText(this);
			      buildername.setTitle("Enter book name");
			      buildername.setCancelable(false);
			      buildername.setView(bookname);
			      buildername.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = bookname.getText().toString();
			            	 booktitle.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert = buildername.create();
			      alert.show();
			      break;
			case R.id.TextView18:
				final EditText textView118 = new EditText(this);
				builderauthor.setTitle("Enter Authors name");
				builderauthor.setCancelable(false);
				builderauthor.setView(textView118);
				builderauthor.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = textView118.getText().toString();
			            	 textView18.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert1 = builderauthor.create();
			      alert1.show();
				break;
			case R.id.TextView20:
				final EditText textView120 = new EditText(this);
				builderisbn.setTitle("Enter ISBN number");
				builderisbn.setCancelable(false);
				builderisbn.setView(textView120);
				builderisbn.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = textView120.getText().toString();
			            	 textView20.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert3 = builderisbn.create();
			      alert3.show();
				break;
			case R.id.TextView16:
				final EditText textView116 = new EditText(this);
				builderyear.setTitle("Enter publising year");
				builderyear.setCancelable(false);
				builderyear.setView(textView116);
				builderyear.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = textView116.getText().toString();
			            	 textView16.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert4 = builderyear.create();
			      alert4.show();
				break;
			case R.id.TextView14:
				final EditText textView114 = new EditText(this);
				builderedition.setTitle("Enter books edition");
				builderedition.setCancelable(false);
				builderedition.setView(textView114);
				builderedition.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = textView114.getText().toString();
			            	 textView14.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert5 = builderedition.create();
			      alert5.show();
				break;
			case R.id.TextView12:
				final EditText textView112 = new EditText(this);
				builderemail.setTitle("Enter your email");
				builderemail.setCancelable(false);
				builderemail.setView(textView112);
				builderemail.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = textView112.getText().toString();
			            	 textView12.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert6 = builderemail.create();
			      alert6.show();
				break;
			case R.id.TextView10:
				final EditText textView110 = new EditText(this);
				builderprise.setTitle("Enter Prise");
				builderprise.setCancelable(false);
				builderprise.setView(textView110);
				builderprise.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = textView110.getText().toString();
			            	 textView10.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert7 = builderprise.create();
			      alert7.show();
				break;
			
			case R.id.TextView06:
				final EditText textView106 = new EditText(this);
				buildercomment.setTitle("Enter Your Comment");
				buildercomment.setCancelable(false);
				buildercomment.setView(textView106);
				buildercomment.setPositiveButton("Ok", new DialogInterface.OnClickListener()
			          {
			            public void onClick(DialogInterface dialog, int id)
			            {
			            	 String textString = textView106.getText().toString();
			            	 textView06.setText(String.valueOf(textString));
			              dialog.cancel();
			            }
			          });
			      AlertDialog alert9 = buildercomment.create();
			      alert9.show();
				break;
			
			      
			}
        
	   
			
	    sendButton.setOnClickListener(new OnClickListener()
	    {

	      public void onClick(View view)
	      {
	        pd = ProgressDialog.show(Trade.this, "Please wait ..", "Sending data", true, false);
	        Thread thread = new Thread(Trade.this);
	        thread.start();
	      }
	    });

}

	  private void sendData()
	  {
	    BookBrain client = new BookBrain(WEB_URI + "books_post.php");
	    client.addParam("Title", booktitle.getText().toString());
	    client.addParam("Author", textView18.getText().toString());
	    client.addParam("ISBN", textView20.getText().toString());
	    client.addParam("Year", textView14.getText().toString());
	    client.addParam("Edition", textView14.getText().toString());
	    client.addParam("Email", textView12.getText().toString());
	    client.addParam("Prise", textView10.getText().toString());
	    client.addParam("Thunbnail", checkBox1.getText().toString());//Danger
	    client.addParam("Comment", textView06.getText().toString());
	    if(radio0.isChecked()==true)
		    client.addParam("ForSale", "1");// Danger
	    else
		    client.addParam("ForSale", "0");// Danger

	    try
	    {
	      client.execute(RequestMethod.GET);

	      String response = client.getResponse();

	      Message msg = Message.obtain();
	      Bundle bndl = new Bundle();
	      bndl.putString("message", response);
	      msg.setData(bndl);

	      handler.sendMessage(msg);
	    } catch (Exception ex)
	    {
	      ex.printStackTrace();
	    }
	  }

	  public void run()
	  {
	    sendData();
	  }

	  private Handler handler = new Handler()
	  {
	    @Override
	    public void handleMessage(Message msg)
	    {
	      pd.dismiss();
	      builder.setMessage(msg.getData().getString("message"))
	          .setCancelable(false)
	          .setPositiveButton("Ok", new DialogInterface.OnClickListener()
	          {
	        	  
	            public void onClick(DialogInterface dialog, int id)
	            {
	              dialog.cancel();
	    	      startActivityForResult(new Intent(Trade.this,com.example.universe.bookplanet.Avalible.class), 0);

	            }
	            
	          });

	      AlertDialog alert = builder.create();

	      alert.show();

	    }

	    
	    
	  };


	

	
	}
