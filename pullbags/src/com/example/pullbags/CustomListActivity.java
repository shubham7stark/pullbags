package com.example.pullbags;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.LoaderManager;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CustomListActivity extends ListFragment{
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	 View v = inflater.inflate(R.layout.custom_fragment_activity, container , false);
	   return v;
	}
	
	@Override
	public void onResume() {
		
		super.onResume();
	}

	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
	
	}
	
	
	public class RetrieveList extends AsyncTask<String, String, String>
	{
        ProgressDialog progressdialog;
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			
			HttpClient httpclient = new DefaultHttpClient();
	        String responseString = null;
	               
	        URI website = new URI("https://server.com:8443/XoW"); 
	        HttpGet request = new HttpGet();
	        request.setURI(website);
	        
	        try {
	        	
	      //  HttpEntity entity = response.getEntity();
            // If the response does not enclose an entity, there is no need
            // to worry about connection release

            if (entity != null) {

                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
              
        //        String result= convertStreamToString(instream);
               
                // A Simple JSONObject Creation
                JSONObject json=new JSONObject(result);
                
              
                // A Simple JSONObject Parsing
                JSONArray nameArray=json.names();
                
                JSONArray jArray=json.toJSONArray(nameArray);
                
                for (int i=0; i < jArray.length(); i++)
                {
                        JSONObject oneObject = jArray.getJSONObject(i);
                        // Pulling items from the array
                        String oneObjectsItem = oneObject.getString("STRINGNAMEinTHEarray");
                        String oneObjectsItem2 = oneObject.getString("anotherSTRINGNAMEINtheARRAY");
                }
                
                // Closing the input stream will trigger connection release
                instream.close();
            }


        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
				
		}

		
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			progressdialog = ProgressDialog.show(RetrieveList.this, "You Data is loading....", "It ll take sometime to load..");
			super.onPreExecute();	
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			progressdialog.dismiss();		
			}

		@Override
		protected void onProgressUpdate(String... values) {
			// TODO Auto-generated method stub
			super.onProgressUpdate(values);
		}
		
	}
	
}