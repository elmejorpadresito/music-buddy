package edu.luc.mb;

import android.os.Bundle;
import android.app.Activity;
import android.content.*;
import android.view.*;
import android.widget.*;
import luc.mb.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
			
		
		Button a = (Button) findViewById(R.id.learn_button);
		a.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent a = new Intent(MainActivity.this, Learn.class);  
				startActivity(a);
			}
		});
		
		Button test = (Button) findViewById(R.id.test_button);
		test.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent b = new Intent(MainActivity.this, QuizFunActivity.class);
				startActivity(b);
				
				Toast.makeText(getBaseContext(), "Are you ready?",
						Toast.LENGTH_SHORT).show();
			}
		});		
		
		Button resources = (Button) findViewById(R.id.resources_button);
		resources.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
						
				Intent c = new Intent(MainActivity.this, Resources.class);
				startActivity(c);
			}
		});
		
		Button contact = (Button) findViewById(R.id.contact_button);
		contact.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
						
				Intent d = new Intent(MainActivity.this, ContactUs.class);
				startActivity(d);
			}
		});
		
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
	
}
