

# Technical Documentation #

Technical documentation for Music Buddy Version 1.2.6


# Splash Screen #

  * `Splash.java`

When the application is launched, the splash screen is loaded featuring the MB logo, then it launches the main menu screen

# Main Screen #

  * `MainActivity.java`

After the application loads upon launch, the main menu screen is displayed which includes the Music Buddy logo and several activities to choose from. This is where the user chooses an activity using the buttons created by onCreate().

## _protected void onCreate()_ ##

A button is created for each activity available (Learn, Quiz, Resources, Contact Us)
```
   Button a = (Button) findViewById(R.id.learn_button);
   a.setOnClickListener(new View.OnClickListener() {
       public void onClick(View v) {
				
	   Intent a = new Intent(MainActivity.this, Learn.class);  
	   startActivity(a);
       }
   });
```

When a button is clicked, the corresponding activity is launched
The UI Layout is determined by activity\_main.xml


# Learn Screen #

  * `Learn.java`

Arrays containing the content image files and corresponding text descriptions are defined as private global variables (so they may be passed to the activity which will display them to the UI)
```
   private static String[] NOTES = new String[]{" Treble Clef", "Treble Clef Middle C", "Treble Clef D"…};
	
   private static int[] IMAGES = new int[] {R.drawable.treble_clef, R.drawable.treb_middle_c, R.drawable.treb_d…};
```

## _protected void onCreate()_ ##

Buttons are created for each subcategory
When a button is clicked, the arrays corresponding to the category are sent to the next activity
```
   Button b = (Button) findViewById(R.id.treb_button);
   b.setOnClickListener(new View.OnClickListener() {
       public void onClick(View v) {
				
	   Intent b = new Intent(Learn.this, HorizontalListViewDemo.class); 
	   b.putExtra("values", NOTES);
	   b.putExtra("images", IMAGES);
	   startActivity(b);
	}
   });
```

# Content Screens #

  * `HorizontalListViewDemo.java`

`list_view_item.xml` - sets up the graphical layout of each item in the horizontal list view

## _protected void onCreate()_ ##

Get the arrays defined in `Learn.java` that were sent from a button press on the Learn Screen
Set these as global variables "values" and "images"
```
   private static String[] values;
   private static int[] images;
```

Use an adapter to push multiple content files through a scrollable horizontal list
```
   super.onCreate(savedInstanceState);
   Bundle extras = getIntent().getExtras();
   values = extras.getStringArray("values");
   images = extras.getIntArray("images");

   setContentView(R.layout.horizontal_list_view);
		
   HorizontalListView listview = (HorizontalListView) findViewById(R.id.listview);
   listview.setAdapter(mAdapter);
```

An adapter is used to populate a listview from an array containing data by creating a view for each item in the dataset array

## _public void onBackPressed()_ ##

Finish the activity
```
   @Override
   public void onBackPressed() {
       super.onBackPressed();
       this.finish();
   }
```
This is so the activity defined by `HorizontalListViewDemo.java` can be used again for different content



## _Base Adapter_ ##

From Android documentation:
> An Adapter object acts as a bridge between an AdapterView and the underlying data for that view. The Adapter provides access to the data items. The Adapter is also responsible for making a View for each item in the data set.

http://developer.android.com/reference/android/widget/Adapter.html

### _getView()_ ###

Sets up a view for each item in the scroll list
TextView = the layout specified in the xml
ImageView = layout in xml

Set this image to be the one pointed to by images[position](position.md)
Set this text to be the one pointed to by values[position](position.md)
```
   @Override
   public View getView(int position, View convertView, ViewGroup parent) {
       View rowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, null);
       TextView title = (TextView) rowView.findViewById(R.id.title);
       ImageView imageView = (ImageView) rowView.findViewById(R.id.image);
	
       imageView.setImageResource(images[position]);
	
       title.setText(values[position]); 
			
       return rowView;
   }
```

From the Android documentation:

> public abstract View getView (int position, View convertView, ViewGroup parent)

> Get a View that displays the data at the specified position in the data set. You can either create a View manually or inflate it from an XML layout file. When the View is inflated, the parent View (GridView, ListView...) will apply default layout parameters unless you use inflate(int, android.view.ViewGroup, boolean) to specify a root view and to prevent attachment to the root.

> Parameters

> position: The position of the item within the adapter's data set of the item whose view we want.

> convertView: The old view to reuse, if possible. Note: You should check that this view is non-null and of an appropriate type before using. If it is not possible to convert this view to display the correct data, this method can create a new view. Heterogeneous lists can specify their number of view types, so that this View is always of the right type (see getViewTypeCount() and getItemViewType(int)).

> parent: The parent that this view will eventually be attached to

> Returns
> A View corresponding to the data at the specified position.

http://developer.android.com/reference/android/widget/Adapter.html#getView%28int,%20android.view.View,%20android.view.ViewGroup%29

# Contact Us Screen #

  * `ContactUs.java`

A list of options to allow the user to contact the developing team. The features include automatic emailing and calling by simply pressing one of the options from the list handler.

## _onListItemClick()_ ##

The onListItemClick works by ordering the events that will occur on click via the case number. The first case corresponds to the first item on the list. The tile of the items are determined in an static array.

```
protected void onListItemClick(ListView l, View v, int position, long id) {
	super.onListItemClick(l, v, position, id);
	switch (position) {
		case 0:
		AlertDialog.Builder alert = new AlertDialog.Builder(context);
	        alert.setTitle("About Music Buddy"); //Set Alert dialog title here
	        alert.setMessage("Thank you for using our App!"); //Message here
	        AlertDialog alertDialog = alert.create();
	        alertDialog.show();
		break;

		case 1:
		break;
		}
	}

static final String[] NEWS = new String[] { "About", "Acknowledgements"  };
```

Android Documentation:

> This method will be called when an item in the list is selected. Subclasses should override.
> Subclasses can call getListView().getItemAtPosition(position) if they need to access the data associated with the selected item.

> Parameters
  * l - The ListView where the click happened
  * v - The view that was clicked within the ListView
  * position - The position of the view in the list
  * id	- The row id of the item that was clicked

http://developer.android.com/reference/android/app/ListActivity.html

# Quizzes Screen #

  * `Quizzes.java`
  * `QuizFunActivity.java`
  * `QuestionActivity.java`

The way the quizzes were set up to work is by populating information on to empty edit boxes and radio buttons. The layout and look are all provided by the `question.xml` file.

The function of `QuizFunActivity.java` and `QuestionActivity` is to pull the information to populate the edit boxes and radio buttons. It pulls the information from a specific target using the JSON method. In this case the questions are located in the RAW folder of the application itself. However, a JSON Array can be used to pull information from the web just as easily.

This is how the questions are read from its original source and loaded into the format of the xml.

## _JSONArray & JSONObject_ ##

```
private void loadQuestions() throws Exception {
    	try {
		InputStream questions = this.getBaseContext().getResources()
				.openRawResource(R.raw.questions);
		bReader = new BufferedReader(new InputStreamReader(questions));
		StringBuilder quesString = new StringBuilder();
		String aJsonLine = null;
		while ((aJsonLine = bReader.readLine()) != null) {
			quesString.append(aJsonLine);
		}
		Log.d(this.getClass().toString(), quesString.toString());
		JSONObject quesObj = new JSONObject(quesString.toString());
		quesList = quesObj.getJSONArray("Questions");
		Log.d(this.getClass().getName(),
				"Num Questions " + quesList.length());
    	} catch (Exception e){
    		
    	} finally {
		try {
			bReader.close();
		} catch (Exception e) {
			Log.e("", e.getMessage().toString(), e.getCause());
		}
    }
```

Android Documentation:

> A dense indexed sequence of values. Values may be any mix of JSONObjects, other JSONArrays, Strings, Booleans, Integers, Longs, Doubles, null or NULL. Values may not be NaNs, infinities, or of any type not listed here.

> JSONArray has the same type coercion behavior and optional/mandatory accessors as JSONObject. See that class' documentation for details.

http://developer.android.com/reference/org/json/JSONArray.html

# Resources Screen #

  * `Resources.java`

The Resources screen provides a list of buttons such as the Main Screen. The list provides the user with a variety of links to relevant material for further studying.

## _protected void onCreate()_ ##

Similar to the Main Menu Screen, Buttons are created for each subcategory
When a button is clicked, the user is sent to the corresponding website.

```
	Button a = (Button) findViewById(R.id.basic_piano_notes);
	a.setOnClickListener(new View.OnClickListener() {
		public void onClick(View v) {
				
		String url = "http://www.youtube.com/watch?v=RjOr95LegJo";
		Intent a = new Intent(Intent.ACTION_VIEW);
		a.setData(Uri.parse(url));
		startActivity(a);
	}
});
```

# Res Folder #

All Android applications have a Res folder. In this folder you will find many of the resources that are needed for the Application to run independently. Anything from pictures to layouts and sounds are enclosed on their specified folders.

A tree branch of our Res folders looks like this:

  * drawable - All images used by the application.
  * layout - The layout for each activity.
  * menu - The layout for the menu key.
  * raw - Any additional resources such as sounds, and additional support files
  * values - All strings and styles for the application.

From the Android Documentation:

> _android.content.res_

> Contains classes for accessing application resources, such as raw asset files, colors, drawables, media or other other files in the package, plus important device configuration details (orientation, input types, etc.) that affect how the application may behave.

http://developer.android.com/reference/android/content/res/package-summary.html

# XML Files #

  * `activity_main.xml`
  * `contact.xml`
  * `horizontal_list_view.xml`
  * `learn.xml`
  * `list_view_item.xml`
  * `question.xml`
  * `resources.xml`
  * `splash.xml`

XML files provide the content layout for each screen in the Application. Each XML file corresponds to one or more of the activities that were created.

The following is an snippet from `activity_main.xml` to further explain how it all works.

```
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".Learn" >

    <ImageView
        android:id="@+id/splashscreen"
        android:layout_width="match_parent"
        android:layout_height="0dip"
        android:layout_gravity="center"
        android:layout_weight="0.68"
        android:contentDescription="@string/logo"
        android:scaleType="fitCenter"
        android:src="@drawable/splash_logo"
        android:clickable="true" />

    <ScrollView
        android:id="@+id/scrollView1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" >

        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:orientation="vertical" >

            <Button
                android:id="@+id/learn_button"
                android:layout_width="match_parent"
                android:layout_height="60dp"
                android:clickable="true"
                android:gravity="center"
                android:text="@string/learn_button"
                android:textSize="25sp" />
        </LinearLayout>
    </ScrollView>
</LinearLayout> 
```

The Linear Layout is the overall layout of the screen, since it is also the first layout in the XML document it must declare the schema.

The Scroll View is a container that will allow for the buttons to move up and down if the user's screen is too small to fit all options. This is a good way to make sure that the application is compatible with the most devices.

The Buttons are the containers that will take the information from the Java files in the application. The Java files can find them with the help of the android:id property. The rest of the properties specify the look and feel of each button. Only one of the buttons is shown in this documentation example.

# RAW Files #

  * `music_buddy_theme.mp3`
  * `questions.txt`

RAW files are stored internally within the application. In the case of Music Buddy the music\_buddy\_theme.mp3 and questions.txt provide the necessary files to play the music, and obtain the questions for the quiz.

The music\_buddy\_theme.mp3 was created by Juan Fuentes with the help of _Audiotool_ an Open Source Google Chrome Application. The mp3 track can be found here:

> http://www.audiotool.com/user/juan_antonio_fuentes/tracks/

There is a very strong possibility that the track will change as it needs to be further edited. New track submissions are always welcome, as long as they are produced under the _Creative Commons Licence (CC BY-NC-SA 3.0)._ For more details please go to:

> http://creativecommons.org/licenses/by-nc-sa/3.0/