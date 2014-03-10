package com.example.universe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import com.example.universe.utils.RequestMethod;
import com.example.universe.utils.RestClient;
import com.example.universe.utils.BookBrain;

//import com.example.universe.utils.UrlBuilder;

public class B_tdemodata extends Activity implements Runnable
{
	  public static final String WEB_URI = "http://server1.valnir.com/solutionbox/";
	  private Button sendButton;
	  private EditText user;
	  private EditText message;

	  private ProgressDialog pd;
	  AlertDialog.Builder builder;

	  /**
	   * Called when the activity is first created.
	   */
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tdemodata);

	    builder = new AlertDialog.Builder(this);

	    sendButton = (Button) findViewById(R.id.btn_send);
	    user = (EditText) findViewById(R.id.txt_username);
	    message = (EditText) findViewById(R.id.txt_message);

	    sendButton.setOnClickListener(new View.OnClickListener()
	    {

	      public void onClick(View view)
	      {
	        pd = ProgressDialog.show(B_tdemodata.this, "Please wait ..", "Sending data", true, false);
	        Thread thread = new Thread(B_tdemodata.this);
	        thread.start();
	      }
	    });

	  }

	  private void sendData()
	  {
	    BookBrain client = new BookBrain(WEB_URI + "solutionbox.php");
	    client.addParam("user", user.getText().toString());
	    client.addParam("message", message.getText().toString());

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
	            }
	          });
	      AlertDialog alert = builder.create();
	      alert.show();
	    }
	  };
	}
