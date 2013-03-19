package edu.luc.mb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Learn extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn);

		// Added this to try to launch a list view
		
		Button a = (Button) findViewById(R.id.go_button);
		a.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent a = new Intent(Learn.this, ListViewLearnActivity.class);  
				startActivity(a);
				
				Toast.makeText(getBaseContext(), "Get Ready to List",
						Toast.LENGTH_SHORT).show();
			}
		});
		
		Button b = (Button) findViewById(R.id.list_button);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent b = new Intent(Learn.this, HorizontalListViewDemo.class);  
				startActivity(b);
				
				Toast.makeText(getBaseContext(), "Get Ready to Horizontal List",
						Toast.LENGTH_SHORT).show();
			}
		});
	}
}