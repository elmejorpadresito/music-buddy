package edu.luc.mb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Learn extends Activity {
	
	private static String[] NOTES = new String[]{" Treble Clef", "Treble Clef Middle C", "Treble Clef D", "Treble Clef E", "Treble Clef F", "Treble Clef G", "Treble Clef A",
												 "Treble Clef B", "Treble Clef C", "Treble Clef D", "Treble Clef E", "Treble Clef F", "Treble Clef G",
												 "Treble Clef A", "Treble Clef B", "Treble Clef C"};
	
	private static int[] IMAGES = new int[] {R.drawable.treble_clef, R.drawable.treb_middle_c, R.drawable.treb_d, R.drawable.treb_e, R.drawable.treb_f, R.drawable.treb_g, R.drawable.treb_a,
											 R.drawable.treb_b, R.drawable.treb_c, R.drawable.treb_d1, R.drawable.treb_e1, R.drawable.treb_f1, R.drawable.treb_g1,
											 R.drawable.treb_a1, R.drawable.treb_b1, R.drawable.treb_c1};
	
	private static String[] BASS_NOTES = new String[]{"Bass Clef", "Bass Clef Middle C"};
	private static int[] BASS_IMGS = new int[]{R.drawable.bass_clef, R.drawable.bass_middle_c};
	
	private static String[] N_TYPES = new String[]{"Sixteenth Note", "Sixteenth Rest", "Eighth Note", "Eighth Rest", "Quarter Note", "Quarter Rest",
												   "Half Note", "Half Rest", "Whole Note", "Whole Rest"};
	
	private static int[] NTYP_IMGS = new int[]{R.drawable.sixteenth_note, R.drawable.sixteenth_rest, R.drawable.eighth_note, R.drawable.eighth_rest, R.drawable.quarter_note,
													 R.drawable.quarter_rest, R.drawable.half_note, R.drawable.half_rest, R.drawable.whole_note, R.drawable.whole_rest};
	
	private static String[] DYNAMICS = new String[]{"pianissimo", "piano", "mezzo-piano", "mezzo-forte", "forte", "fortissimo", "crescendo", "diminuendo"};
	
	private static int[] DYN_IMGS = new int[]{R.drawable.pianissimo, R.drawable.piano, R.drawable.mezzo_piano, R.drawable.mezzo_forte, R.drawable.forte, R.drawable.fortissimo, R.drawable.crescendo, R.drawable.diminuendo};
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.learn);

		// Added this to try to launch a list view
		
/*		Button a = (Button) findViewById(R.id.go_button);
		a.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent a = new Intent(Learn.this, ListViewLearnActivity.class);  
				startActivity(a);
				
				Toast.makeText(getBaseContext(), "Get Ready to List",
						Toast.LENGTH_SHORT).show();
			}
		}); */
		
		Button b = (Button) findViewById(R.id.treb_button);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent b = new Intent(Learn.this, HorizontalListViewDemo.class); 
				b.putExtra("values", NOTES);
				b.putExtra("images", IMAGES);
				startActivity(b);
				
				Toast.makeText(getBaseContext(), "Get Ready to Treble Clef!",
						Toast.LENGTH_SHORT).show();
			}
		});
		
		Button c = (Button) findViewById(R.id.bass_button);
		c.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent c = new Intent(Learn.this, HorizontalListViewDemo.class); 
				c.putExtra("values", BASS_NOTES);
				c.putExtra("images", BASS_IMGS);
				startActivity(c);
				
				Toast.makeText(getBaseContext(), "Get Ready to Bass Clef!",
						Toast.LENGTH_SHORT).show();
			}
		}); 
		
		Button d = (Button) findViewById(R.id.dynamics_button);
		d.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent d = new Intent(Learn.this, HorizontalListViewDemo.class); 
				d.putExtra("values", DYNAMICS);
				d.putExtra("images", DYN_IMGS);
				startActivity(d);
				
				Toast.makeText(getBaseContext(), "Get Ready to Dynamics!",
						Toast.LENGTH_SHORT).show();
			}
		});
		
		Button e = (Button) findViewById(R.id.note_types_button);
		e.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				Intent e = new Intent(Learn.this, HorizontalListViewDemo.class); 
				e.putExtra("values", N_TYPES);
				e.putExtra("images", NTYP_IMGS);
				startActivity(e);
				
				Toast.makeText(getBaseContext(), "Get Ready to Note Types!",
						Toast.LENGTH_SHORT).show();
			}
		});
		
	}
}