package com.example.pullbags;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class CustomDialogFragment extends DialogFragment{

	ContectItem contect;
	public CustomDialogFragment(ContectItem contect){
		this.contect = contect;
		}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
	    // TODO Auto-generated method stub
	    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	    LayoutInflater inflater = getActivity().getLayoutInflater();

	    View view = inflater.inflate(R.layout.dialog_fragment,null);

	    

	    
	    //tell the builder that you wan't that inflated layout to show
	    // and then set the button (negative/positive in this case) if you want
	    
	    builder.setView(
	            view)
	            .setPositiveButton("OK",
	                    new DialogInterface.OnClickListener() {
	                        @Override
	                        public void onClick(DialogInterface arg0, int arg1) {
	                            // TODO Auto-generated method stub
	                        }
	                    })
	            .setNegativeButton("CANCEL",
	                    new DialogInterface.OnClickListener() {

	                        @Override
	                        public void onClick(DialogInterface dialog,
	                                int which) {
	                            // TODO Auto-generated method stub
	                        }
	                    });

	    return builder.create();
	}
	
}


