package com.example.tharani.sortinglist;
/*import is libraries imported for writing the code
* AppCompatActivity is base class for activities
* Bundle handles the orientation of the activity
*/

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;



public class MainActivity extends AppCompatActivity {
    /*onCreate is the first method in the life cycle of an activity
    savedInstance passes data to super class,data is pull to store state of application
  * setContentView is used to set layout for the activity
  *R is a resource and it is auto generate file
  * activity_main assign an integer value*/
    // declaring variables
    Button ascendBtn;
    Button descendBtn;
    ArrayAdapter<String>arrayAdapter;
    ListView lstViw;
    // creating array of month name
    String[] monthName = {"January", "Feb", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // In here getting the widgets reference from XML layout
        lstViw = findViewById( R.id.listView );
        /**
         * Using ArrayAdapter because the adapter converts an ArrayList of objects into
         * View items loaded into the ListView container.
         */

        arrayAdapter = new ArrayAdapter<String>(MainActivity.this,R.layout.list_items,R.id.tv,monthName);
        lstViw.setAdapter( arrayAdapter );
        // and in here getting the widgets reference from XML layout for assigning and designing button.
        ascendBtn =  findViewById( R.id.ascendingBtn );
        descendBtn =  findViewById( R.id.descendingBtn );
        // setting OnClickListener for assigning oder
        ascendBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort( monthName );
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText( getApplicationContext(), "Month in ascending Oder  ", Toast.LENGTH_SHORT ).show();
                /*
                LENGTH_SHORT Shows the view or text notification for a long period of time.
                int LENGTH_SHORT Show the view or text notification for a short period of toast*/

            }
        } );
        // setting OnClickListener for designing oder
        descendBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Arrays.sort(monthName,Collections.<String>reverseOrder());
                arrayAdapter.notifyDataSetChanged();
                Toast.makeText( getApplicationContext(), "Month in descending Oder", Toast.LENGTH_SHORT ).show();
            }
        } );

    }

}