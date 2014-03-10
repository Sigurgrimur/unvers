package com.example.universe;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.view.View.OnClickListener;


public class A_My_Galaxy extends Activity implements OnClickListener {
	
	
	
	RelativeLayout rlbook_browse, rlbook_sell, rlthought_browse, rlthought_share;
	RelativeLayout rlthought_manage,	rlstudent_events, rlstudent_help;
	RelativeLayout rlproject_avalible, rlproject_post,	rlproject_manage, rlrest_special, rlrest_offers;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.a_my_galaxy);
		
		
		 // I now have all my UI in java memory
		rlbook_browse = (RelativeLayout)findViewById(R.id.rlbook_browse);
		rlbook_sell = (RelativeLayout)findViewById(R.id.rlbook_sell);
		rlthought_browse = (RelativeLayout)findViewById(R.id.rlcoll_unicoll);
		rlthought_share = (RelativeLayout)findViewById(R.id.rlcoll_unicast);
		rlthought_manage = (RelativeLayout)findViewById(R.id.rlcoll_my);
		rlstudent_events = (RelativeLayout)findViewById(R.id.rlstudent_events);
		rlstudent_help = (RelativeLayout)findViewById(R.id.rlstudent_peer);
		rlproject_avalible = (RelativeLayout)findViewById(R.id.rlproject_avalible);
		rlproject_post = (RelativeLayout)findViewById(R.id.rlproject_post);
		rlproject_manage = (RelativeLayout)findViewById(R.id.rlproject_manage);
		rlrest_special = (RelativeLayout)findViewById(R.id.rlrest_special);
		rlrest_offers = (RelativeLayout)findViewById(R.id.rlrest_offers);


		
		// Define RelativeMain listeners
		rlbook_browse.setOnClickListener(this);
		rlbook_sell.setOnClickListener(this);
		rlthought_browse.setOnClickListener(this);
		rlthought_share.setOnClickListener(this);
		rlthought_manage.setOnClickListener(this);
		rlstudent_events.setOnClickListener(this);
		rlstudent_help.setOnClickListener(this);
		rlproject_avalible.setOnClickListener(this);
		rlproject_post.setOnClickListener(this);
		rlproject_manage.setOnClickListener(this);
		rlrest_special.setOnClickListener(this);
		rlrest_offers.setOnClickListener(this);
		
	}
		public void onClick(View src) {
			switch(src.getId()){
			case	R.id.rlbook_browse:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.bookplanet.Avalible.class), 0);

				break;
			case	R.id.rlbook_sell:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.bookplanet.Trade.class), 0);

				break;
			case	R.id.rlcoll_unicoll:
	    		 
				startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.collective.UniCollective.class), 0);

				break;
			case	R.id.rlcoll_unicast:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.collective.UniCast.class), 0);

				break;
			case	R.id.rlcoll_my:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.collective.My_UniCast.class), 0);

				break;
			case	R.id.rlstudent_events:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.studentworld.Events.class), 0);

				break;
			
			case	R.id.rlstudent_peer:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.studentworld.PeerSupport.class), 0);

				break;
			case	R.id.rlproject_avalible:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.ideaunivers.Idea_Galaxy.class), 0);

				break;
			case	R.id.rlproject_post:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.ideaunivers.IdeaCast.class), 0);

				break;
			case	R.id.rlproject_manage:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.ideaunivers.My_IdeaCast.class), 0);

				break;
			case	R.id.rlrest_special:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.resturant.ToDay.class), 0);

				break;
			case	R.id.rlrest_offers:
	    		 startActivityForResult(new Intent(A_My_Galaxy.this,com.example.universe.resturant.Offers.class), 0);

				break;
				
			}

	}

	
}
