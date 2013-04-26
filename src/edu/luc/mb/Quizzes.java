package edu.luc.mb;

import luc.mb.R;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Quizzes extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, NEWS));
		getListView().setTextFilterEnabled(true);
	}
	
	// this context will use when we work with Alert Dialog
    final Context context = this;

	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			Intent b = new Intent(this, QuizFunActivity.class);
			startActivity(b);
			
			Toast.makeText(getBaseContext(), "Are you ready?",
					Toast.LENGTH_SHORT).show();
			break;
			
		case 1:
			AlertDialog.Builder alert = new AlertDialog.Builder(context);
	        alert.setTitle("Name the Notes"); //Set Alert dialog title here
	        alert.setMessage("This quiz is currently in development, please come back at a latter time, thank you!"); //Message here
	        AlertDialog alertDialog = alert.create();
	        alertDialog.show();
			break;
		}

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
		
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
        case R.id.menu_exit:
        	System.exit(1);
            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	static final String[] NEWS = new String[] { "Music Theory - Hard", "Name the Notes - Medium", };
}