package com.example.universe.collective;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.universe.R;
import com.example.universe.bookplanet.Trade;
import com.example.universe.collective.UniCast;
import com.example.universe.utils.BookBrain;
import com.example.universe.utils.RequestMethod;


public class UniCast extends Activity implements  OnClickListener, Runnable
{
	  AlertDialog.Builder builder;

	  public static final String WEB_URI = "http://server1.valnir.com/solutionbox/";
	  private ProgressDialog pd;
	  AlertDialog.Builder dialog_name;

	Button Button01,Button02,Button03,Buttonsend;
	ViewFlipper vf;
	RelativeLayout rel1,rel2,rel3;
	  public TextView username,title, post;
	  public TextView etusername, ettitle, etpost;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.coll_unicast);
	dialog_name= new AlertDialog.Builder(this);
	
	vf = (ViewFlipper) findViewById(R.id.ViewFlipper01);
	Button01 = (Button) findViewById(R.id.Button01);
	Button02 = (Button) findViewById(R.id.Button02);
	Button03 = (Button) findViewById(R.id.Button03);
	Buttonsend = (Button) findViewById(R.id.buttonsend);
	rel1=(RelativeLayout)findViewById(R.id.relativeLayout1);
	rel2=(RelativeLayout)findViewById(R.id.relativeLayout2);
	rel3=(RelativeLayout)findViewById(R.id.relativeLayout3);
	etusername = (TextView)findViewById(R.id.username);
	ettitle =(TextView)findViewById(R.id.postname);
	etpost =(TextView)findViewById(R.id.post);
    builder = new AlertDialog.Builder(this);

	Button01.setOnClickListener(this);
	Button02.setOnClickListener(this);
	Button03.setOnClickListener(this);
	Buttonsend.setOnClickListener(this);
	rel1.setOnClickListener(this);
	rel2.setOnClickListener(this);
	rel3.setOnClickListener(this);

	}

	@Override
	public void onClick(View src) {
	// TODO Auto-generated method stub
		
		
			
			switch(src.getId()){
			case	R.id.relativeLayout1:
				vf.showNext();
				
				break;
			
			case	R.id.relativeLayout2:
				vf.showNext();
				vf.showNext();
				break;
			
			case	R.id.relativeLayout3:
				vf.showPrevious();

				break;
			case R.id.Button01:
				EditText utusername =new EditText(this);
				utusername =(EditText) findViewById(R.id.EditText01);
				TextView username = new TextView(this);
				username= (TextView) findViewById(R.id.username);
				String textString = utusername.getText().toString();
				username.setText(String.valueOf(textString));

				vf.showPrevious();
				break;
			case R.id.Button02:

				EditText ettitle = new EditText(this);
				ettitle =(EditText) findViewById(R.id.EditText02);
				TextView title = new TextView(this);
				title= (TextView) findViewById(R.id.postname);
				String textStringtitle = ettitle.getText().toString();
				title.setText(String.valueOf(textStringtitle));
				vf.showPrevious();
				vf.showPrevious();
				break;
			case R.id.Button03:
				EditText etpost = new EditText(this);
				etpost =(EditText) findViewById(R.id.EditText03);
				TextView post = new TextView(this);
				post= (TextView) findViewById(R.id.post);
				String textStringpost = etpost.getText().toString();
				post.setText(String.valueOf(textStringpost));
				
				vf.showNext();

				break;
				
			
			}
		
			
		
		
	
    Buttonsend.setOnClickListener(new OnClickListener()
    {
    
      public void onClick(View view)
      {
    		   		
    	  
    	  
        pd = ProgressDialog.show(UniCast.this, "Please wait ..", "Sending data", true, false);
        Thread thread = new Thread(UniCast.this);
        thread.start();;
      };
    });

}

  private void sendData()
  {
    BookBrain client = new BookBrain(WEB_URI + "Collective_post.php");
    client.addParam("username", etusername.getText().toString());
    client.addParam("title", ettitle.getText().toString());
    client.addParam("post", etpost.getText().toString());
    client.addParam("state", "1");

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
    	      startActivityForResult(new Intent(UniCast.this,com.example.universe.collective.UniCollective.class), 0);

            }
            
          });

      AlertDialog alert = builder.create();

      alert.show();

    }

    
    
  };
	

		
	
	}