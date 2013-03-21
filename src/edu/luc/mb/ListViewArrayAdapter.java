package edu.luc.mb;

import android.os.Bundle;
import android.app.Activity;
import android.content.*;
import android.view.*;
import android.widget.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.*;

public class ListViewArrayAdapter extends ArrayAdapter<String> {
	
	private final Context context;
	private final String[] values;
	
	public ListViewArrayAdapter (Context context, String[] values) 
	{
		super(context, R.layout.list_view_layout, values);
		this.context = context;
		this.values = values;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.list_view_layout, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);
		
		String s = values[position];
		
		System.out.println(s);
		
		if (s.equals("BassMiddleC")) {
			imageView.setImageResource(R.drawable.bass_middle_c);
		} else if (s.equals("TrebleA")) { 
			imageView.setImageResource(R.drawable.treb_a);
		} else if (s.equals("TrebleB")) {
			imageView.setImageResource(R.drawable.treb_b);
		} else {
			imageView.setImageResource(R.drawable.treb_middle_c);
		}
			
		return rowView;
	}
}