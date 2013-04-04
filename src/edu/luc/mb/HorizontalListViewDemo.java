package edu.luc.mb;


import edu.luc.mb.HorizontalListView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;
import android.view.View;


public class HorizontalListViewDemo extends Activity {

	private static String[] values;
	private static int[] images;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		Bundle extras = getIntent().getExtras();
		values = extras.getStringArray("values");
		images = extras.getIntArray("images");

		setContentView(R.layout.horizontal_list_view);

		HorizontalListView listview = (HorizontalListView) findViewById(R.id.listview);
		listview.setAdapter(mAdapter);
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
	}

	private BaseAdapter mAdapter = new BaseAdapter() {

		private OnClickListener mOnButtonClicked = new OnClickListener() {

				@Override
				public void onClick(View v) {
					AlertDialog.Builder builder = new AlertDialog.Builder(HorizontalListViewDemo.this);
					builder.setMessage("hello from " + v);
					builder.setPositiveButton("Cool", null);
					builder.show();
				}
		};

		@Override
		public int getCount() {
			return values.length;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, null);
			TextView title = (TextView) rowView.findViewById(R.id.title);
			ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
	
			imageView.setImageResource(images[position]);
	
			title.setText(values[position]);
	
			return rowView;
		} 

	};
}