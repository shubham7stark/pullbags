package com.example.pullbags;


import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<CustomListItem>{

	Context context;
	List<CustomListItem> list;

	public CustomListAdapter(Context c, List<CustomListItem> l){
		super(c,R.layout.custom_list_item,l);
		context = c;
		list = l;
       }

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.custom_list_item, parent, false);
		CustomListItem obj = list.get(position);
		return rowView;
	}
}
