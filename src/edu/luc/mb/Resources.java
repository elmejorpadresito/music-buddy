package edu.luc.mb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Resources extends Activity {
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.resources);
		
		Button a = (Button) findViewById(R.id.basic_piano_notes);
		a.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.youtube.com/watch?v=RjOr95LegJo";
				Intent a = new Intent(Intent.ACTION_VIEW);
				a.setData(Uri.parse(url));
				startActivity(a);
			}
		});
		
		Button b = (Button) findViewById(R.id.music_leson_reading_music);
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.youtube.com/watch?v=rjD7C6IsBX8";
				Intent b = new Intent(Intent.ACTION_VIEW);
				b.setData(Uri.parse(url));
				startActivity(b);
			}
		});
		
		Button c = (Button) findViewById(R.id.how_read_sheet_music);
		c.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.howtodothings.com/hobbies/a2683-how-to-read-sheet-music.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		Button d = (Button) findViewById(R.id.basic_note_naming);
		d.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.youtube.com/watch?v=9mTKc22xowU";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}); 
		
		Button e = (Button) findViewById(R.id.string_note);
		e.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.stringnote.com/vs/piano3/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}); 
		
		Button f = (Button) findViewById(R.id.capotastomusic);
		f.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.capotastomusic.com/piano-sheet-music/basic.htm";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}); 
     
		Button g = (Button) findViewById(R.id.walt_robeiro);
		g.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://waltribeiro.com/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}); 
	       
		Button h = (Button) findViewById(R.id.how_to_read_music);
		h.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.youtube.com/watch?v=3spcwekxhrE";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}); 
		
		Button i = (Button) findViewById(R.id.pre_piano);
		i.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://prepiano.com/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}); 
					
		Button j = (Button) findViewById(R.id.learning_notes_basics);
		j.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.youtube.com/watch?v=1GqyS3S1MEk";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		}); 

		Button k = (Button) findViewById(R.id.music_learning_workshop);
		k.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.musiclearningworkshop.com/";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});
		
		Button l = (Button) findViewById(R.id.emusictheory);
		l.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.emusictheory.com/learning.html";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});

		Button m = (Button) findViewById(R.id.all_about_trumpet);
		m.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				
				String url = "http://www.allabouttrumpet.com/pdf/BMT/BMT-2nd-ed.pdf";
				Intent i = new Intent(Intent.ACTION_VIEW);
				i.setData(Uri.parse(url));
				startActivity(i);
			}
		});	
	}
}