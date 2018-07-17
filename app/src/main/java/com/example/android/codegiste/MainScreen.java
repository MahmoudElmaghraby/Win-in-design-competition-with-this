package com.example.android.codegiste;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Initialize the list view
    ListView listView ;

    //Initialize the drawer layout
    private DrawerLayout drawerLayout ;

    //Set the ActionBarDrawerToggle
    private ActionBarDrawerToggle toggle ;

    //Set the navigation view
    private NavigationView navigationView ;

    //Setup the arrays that contain the date of single list item
    int[] images = {R.drawable.logo,
            R.drawable.logo,
            R.drawable.logo ,
            R.drawable.logo ,
            R.drawable.logo};
    String[] names = {"Name 1" , "Name 2", "Name 3" ,"Name 4" ,"Name 5"};
    String[] date = {"date 1" , "date 2", "date 3" ,"date 4" ,"date 5"};
    String[] desc = {"desc 1" , "desc 2", "desc 3" ,"desc 4" ,"desc 5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main_screen.xml layout file
        setContentView(R.layout.activity_main_screen);

        //Select our list view from the layout
        listView = (ListView) findViewById(R.id.list);

        //Select the drawer view from the xml file
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        //Set the button in the action bar to the drawer layout
        toggle = new ActionBarDrawerToggle(this , drawerLayout , R.string.open , R.string.close);

        //Add the drawer layout into the button in action bar
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Display the action bar

        //Select the required navigation view from activity_main_screen.xml file
        navigationView = (NavigationView) findViewById(R.id.nav);

        //Set click listener for the navigation view
        navigationView.setNavigationItemSelectedListener(this);

        //Create object from our class that adapt every single list item
        CustomAdapter customAdapter = new CustomAdapter();

        //Put the custom adapter into the list view
        listView.setAdapter(customAdapter);



    }



    /**
     * That class to adapt every single item in his right place
     */
    class CustomAdapter extends BaseAdapter{

        /**
         * Get the number of items in the list view
         * @return
         */
        @Override
        public int getCount() {
            return images.length;
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

            //Select the adapter layout to set on the list view
            convertView = getLayoutInflater().inflate(R.layout.main_screen_adapter , null);

            //Select all the date in every single item in the list view
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView nameTextView = (TextView) convertView.findViewById(R.id.name_textView);
            TextView dateTextView = (TextView) convertView.findViewById(R.id.date_textView);
            TextView descTextView = (TextView) convertView.findViewById(R.id.desc_textView);
            Button likeBtn = (Button) convertView.findViewById(R.id.like_button);
            Button locateBtn = (Button) convertView.findViewById(R.id.locate_button);
            Button mentionBtn = (Button) convertView.findViewById(R.id.mention_button);
            Button favoriteBtn = (Button) convertView.findViewById(R.id.favorite_button);

            //Put the date in its right place in every single item in the list view
            imageView.setImageResource(images[position]);
            nameTextView.setText(names[position]);
            dateTextView.setText(date[position]);
            descTextView.setText(desc[position]);

            //Setup evey one of the four buttons to move to its activity

            //When locate button is clicked --> Go to Location activity
            locateBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainScreen.this , LocateBtn.class);
                    startActivity(intent);
                }
            });

            //When favorite button is clicked --> Go to Favorite activity
            favoriteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainScreen.this , Favorite.class);
                    startActivity(intent);
                }
            });

            return convertView;
        }
    }

    /**
     *To open the menu in the navigation view
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (toggle.onOptionsItemSelected(item)){
            return true ; //Hint :- it is return false by default so we have to handle it
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * TO handle the clicked on every item in the navigation menu
     * @param item
     * @return
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            //If the the home button is clicked
            case R.id.home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;

            //If the the home profile is clicked
            case R.id.profile :
                //Go to Profile activity
                Intent profileIntent = new Intent(MainScreen.this , Profile.class);
                startActivity(profileIntent);
                break;

            //If the the home history is clicked
            case R.id.history :
                //Go to History activity
                Intent historyIntent = new Intent(MainScreen.this , History.class);
                startActivity(historyIntent);
                break;

        }

        return false;
    }

}
