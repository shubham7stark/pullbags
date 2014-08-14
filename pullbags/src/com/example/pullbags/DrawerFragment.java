package com.example.pullbags;


import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
 
@SuppressLint("NewApi")
public class DrawerFragment extends Fragment{
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
 
        int position = getArguments().getInt("position");
        String[] category = getResources().getStringArray(R.array.category);
 
        View v = inflater.inflate(R.layout.drawer_list_item, container, false); 
        TextView tv = (TextView) v.findViewById(R.id.tv_drawer_list_item);
        tv.setText(category[position]);
 
        // Updating the action bar title
        getActivity().getActionBar().setTitle(category[position]);
 
        return v;
    }
}