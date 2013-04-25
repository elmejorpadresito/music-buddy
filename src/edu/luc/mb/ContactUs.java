package edu.luc.mb;

import android.R;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ContactUs extends ListActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, NEWS));
		getListView().setTextFilterEnabled(true);
	}
	
	// this context will use when we work with Alert Dialog
    final Context context = this;

	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			AlertDialog.Builder alert = new AlertDialog.Builder(context);
	        alert.setTitle("About Music Buddy"); //Set Alert dialog title here
	        alert.setMessage("This application is part of an Open Source Project for Loyola University Chicago COMP 412. \nThe project is run under the GNU GPL v3 License. Comments, questions, and suggestions may be submitted to our email address: mscbdd@gmail.com"); //Message here
	        AlertDialog alertDialog = alert.create();
	        alertDialog.show();
			break;

		case 1:
			AlertDialog.Builder acknoledgements = new AlertDialog.Builder(context);
	        acknoledgements.setTitle("Acknoledgements"); //Set Alert dialog title here
	        acknoledgements.setMessage("The Developers would like acknoledgedge the following individuals for their outstanding support and collaboration in the development of this application: \n\n-Corby Schmitz \n-Jason Ong \n-Juan Antonio Fuentes \n-Lauren Van Vleet \n-Melissa Filipiak \n-Rafal Zukowski \n\nThank You!"); //Message here
	        AlertDialog alertDialog1 = acknoledgements.create();
	        alertDialog1.show();
			break;
		
		case 2:
			// Start activity that you want to when 1st item of your list is
			// selected
			Intent DialIntent = new Intent(Intent.ACTION_DIAL,
					Uri.parse("tel:312-380-9704"));
			DialIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(DialIntent);

			Toast.makeText(getBaseContext(), "Press Dial Button",
					Toast.LENGTH_SHORT).show();

			break;

		case 3:
			Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
			emailIntent.setType("message/rfc822");
			startActivity(emailIntent);

			String aEmailList[] = { "mscbdd@gmail.com" };
			String aEmailCCList[] = { "" };
			String aEmailBCCList[] = { "" };

			emailIntent
			.putExtra(android.content.Intent.EXTRA_EMAIL, aEmailList);
			emailIntent.putExtra(android.content.Intent.EXTRA_CC, aEmailCCList);
			emailIntent.putExtra(android.content.Intent.EXTRA_BCC,
					aEmailBCCList);

			emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
					"Report a Bug? Submit Feedback?");

			emailIntent.setType("plain/text");
			emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
					"In order to better serve you, please explain to the best of your ability the problem that you are experiencing, thanks!");

			startActivity(emailIntent);

			break;
			
		}

	}

	static final String[] NEWS = new String[] { "About", "Acknoledgements", "Call Developers [Beta]", "Email Us",  };
}