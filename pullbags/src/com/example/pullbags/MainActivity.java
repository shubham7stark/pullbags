package com.example.pullbags;

import java.util.ArrayList;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;


@SuppressLint("NewApi") 
public class MainActivity extends Activity {
 
	ListView list;
	
    DrawerLayout mDrawerLayout;
    ListView mDrawerList;
    ActionBarDrawerToggle mDrawerToggle;
    String mTitle="";
    FragmentManager fragmentManager;
	FragmentTransaction ft;
    TabHome tabhome;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
 
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  
        ActionBar actionBar = getActionBar();
        actionBar.setHomeButtonEnabled(true);
        setHomeTabPage();
        
        
   	 /*..............................................................................*/
     
   	     mTitle = (String) getTitle();
 
        // Getting reference to the DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
 
        mDrawerList = (ListView) findViewById(R.id.drawer_list);
 
        // Getting reference to the ActionBarDrawerToggle
        mDrawerToggle = new ActionBarDrawerToggle( this,
            mDrawerLayout,
            R.drawable.ic_drawer,
            R.string.drawer_open,
            R.string.drawer_close){
 
                /** Called when drawer is closed */
                public void onDrawerClosed(View view) {
                    getActionBar().setTitle(mTitle);
                    invalidateOptionsMenu();
                }
 
                /** Called when a drawer is opened */
                public void onDrawerOpened(View drawerView) {
                    getActionBar().setTitle("Select Category");
                    invalidateOptionsMenu();
                }
        };
 
        // Setting DrawerToggle on DrawerLayout
        mDrawerLayout.setDrawerListener(mDrawerToggle);
 
        // Creating an ArrayAdapter to add items to the listview mDrawerList
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            getBaseContext(),
            R.layout.drawer_list_item,
            getResources().getStringArray(R.array.category)
        );
 
        // Setting the adapter on mDrawerList
        mDrawerList.setAdapter(adapter);
        // Enabling Home button
        getActionBar().setHomeButtonEnabled(true);
        // Enabling Up navigation
        getActionBar().setDisplayHomeAsUpEnabled(true);
 
        // Setting item click listener for the listview mDrawerList
        mDrawerList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                View view,
                int position,
                long id) {
 
                    // Getting an array of category
                    String[] category = getResources().getStringArray(R.array.category);
 
                    //Currently selected river
                    mTitle = category[position];
 
                    // Creating a fragment object
                    DrawerFragment rFragment = new DrawerFragment();
 
                    // Creating a Bundle object
                    Bundle data = new Bundle();
 
                    // Setting the index of the currently selected item of mDrawerList
                    data.putInt("position", position);
 
                    // Setting the position to the fragment
                    rFragment.setArguments(data);
 
                    // Getting reference to the FragmentManager
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.replace(R.id.content_frame, rFragment);
                    ft.commit();
                    mDrawerLayout.closeDrawer(mDrawerList);
            }
        });
    }
    
    public void setHomeTabPage(){
    	
      fragmentManager = getFragmentManager();
      ft = fragmentManager.beginTransaction();
    	tabhome = new TabHome();
    	
     // ft.replace(R.id.container_frame, tabhome);	
      
      ft.commit();
    }
    
    public void setFragment(){
    
    	 fragmentManager = getFragmentManager();
         ft = fragmentManager.beginTransaction();
       	
        // ft.replace(R.id.container_frame, tabhome);	
         
         ft.commit();
    }
    
    
 
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }
 
    /** Handling the touch event of app icon */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
 
    /** Called whenever we call invalidateOptionsMenu() */
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // If the drawer is open, hide action items related to the content view
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList); 
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
 
    

    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
 
    
   



}

