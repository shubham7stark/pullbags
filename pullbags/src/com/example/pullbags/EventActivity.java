package com.example.pullbags;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EventActivity extends Activity implements OnClickListener{

	String url;
    ImageView imageView;
	TextView name;
	TextView brief;
	TextView stoke_tv;
	TextView price_tv;
	TextView detail;
	EditText qty_edtxt;
	Button submit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	imageView = (ImageView)findViewById(R.id.event_item_image);
	name = (TextView)findViewById(R.id.event_item_name);
	brief =  (TextView)findViewById(R.id.event_item_brief);
	stoke_tv = (TextView)findViewById(R.id.event_stock_txt);
	price_tv = (TextView)findViewById(R.id.event_ptice_txt);
	detail	= (TextView)findViewById(R.id.event_detail_txt);
	qty_edtxt = (EditText)findViewById(R.id.event_qty_edit);
	submit = (Button)findViewById(R.id.event_ok_button);
	
	try {
		JSONObject jsonObj = new JSONObject(getIntent().getStringExtra("product"));
		
		name.setText(jsonObj.getString(""));
		brief.setText(jsonObj.getString(""));
		stoke_tv.setText(jsonObj.getString(""));
		price_tv.setText(jsonObj.getString(""));
		detail.setText(jsonObj.getString(""));
		
		
	} catch (JSONException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	if(v.getId() == R.id.event_ok_button){
		
		
	  }
	}
	
	
	/* async class to load image */
	public class ImageLoadTask extends AsyncTask<Void, Void, Bitmap> {

	
	    public ImageLoadTask(String urls, ImageView imageViews) {
	        url = urls;
	        imageView = imageViews;
	    }

	    @Override
	    protected Bitmap doInBackground(Void... params) {
	        try {
	            URL urlConnection = new URL(url);
	            HttpURLConnection connection = (HttpURLConnection) urlConnection
	                    .openConnection();
	            connection.setDoInput(true);
	            connection.connect();
	            InputStream input = connection.getInputStream();
	            Bitmap myBitmap = BitmapFactory.decodeStream(input);
	            return myBitmap;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

	    @Override
	    protected void onPostExecute(Bitmap result) {
	        super.onPostExecute(result);
	        imageView.setImageBitmap(result);
	    }

	}
	
}
