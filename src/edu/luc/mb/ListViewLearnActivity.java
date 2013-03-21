package edu.luc.mb;

import edu.luc.mb.ListViewArrayAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;


public class ListViewLearnActivity extends ListActivity {
	
	static final  String[] NOTES = new String[] {"BassMiddleC", "TrebleA", "TrebleB", "TrebleMiddleC"};
	static final int[] test = new int[] {R.drawable.bass_middle_c};

	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setListAdapter(new ListViewArrayAdapter(this, NOTES));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id)
	{
		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
	}
	
	
	
	
}

