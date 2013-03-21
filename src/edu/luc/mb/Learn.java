package edu.luc.mb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Learn extends Activity {
	
	private static String[] NOTES = new String[]{"Treble Clef Middle C", "Treble Clef D", "Treble Clef E", "Treble Clef F", "Treble Clef G", "Treble Clef A",
												 "Treble Clef B", "Treble Clef C", "Treble Clef D", "Treble Clef E", "Treble Clef F", "Treble Clef G",
												 "Treble Clef A", "Treble Clef B", "Treble Clef C"};
	
	private static int[] IMAGES = new int[] {R.drawable.treb_middle_c, R.drawable.treb_d, R.drawable.treb_e, R.drawable.treb_f, R.drawable.treb_g, R.drawable.treb_a,
											 R.drawable.treb_b, R.drawable.treb_c, R.drawable.treb_d1, R.drawable.treb_e1, R.drawable.treb_f1, R.drawable.treb_g1,
											 R.drawable.treb_a1, R.drawable.treb_b1, R.drawable.treb_c1};
	
	private static String[] BASS_NOTES = new String[]{"Bass Clef Middle C"};
	private static int[] BASS_IMGS = new int[]{R.drawable.bass_middle_c};
	
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
		
		Button b = (Button) findViewById(R.id.treb_button);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent b = new Intent(Learn.this, HorizontalListViewDemo.class); 
				b.putExtra("values", NOTES);
				b.putExtra("images", IMAGES);
				startActivity(b);
				
				Toast.makeText(getBaseContext(), "Get Ready to Horizontal List",
						Toast.LENGTH_SHORT).show();
			}
		});
		
/*		Button c = (Button) findViewById(R.id.bass_button);
		c.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent c = new Intent(Learn.this, HorizontalListViewDemo.class); 
				c.putExtra("values", BASS_NOTES);
				c.putExtra("images", BASS_IMGS);
				startActivity(c);
				
				Toast.makeText(getBaseContext(), "Get Ready to Horizontal List",
						Toast.LENGTH_SHORT).show();
			}
		}); */
	}
}