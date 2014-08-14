package com.example.pullbags;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.database.SQLException;
import android.os.Bundle;


public class PurchasedItemsActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		/* Get Data frm Database */
		try {
		DatabaseHelper myDbHelper = new DatabaseHelper(this);
		myDbHelper.openDataBase();
		ArrayList<CustomListItem> purchase_list = myDbHelper.getAlItems();
	     } catch (SQLException sqle) {
			throw sqle;
		}
   
	}


	
}
