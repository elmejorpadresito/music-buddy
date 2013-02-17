package edu.luc.mb;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
	
	/**	Button learn = (Button) findViewById(R.id.learn_button);
		learn.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent a = new Intent(MainActivity.this, Learn.class);
				startActivity(a);

		
		Button test = (Button) findViewById(R.id.test_button);
		test.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent b = new Intent(MainActivity.this, Quizz.class);
				startActivity(b);
			}
		});		
		
		Button resources = (Button) findViewById(R.id.resources_button);
		resources.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent c = new Intent(MainActivity.this, Resources.class);
				startActivity(c);
			}
		});
**/		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
		
}
