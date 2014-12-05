package com.example.androidbanking;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class TellerMain extends Activity {
    static String temp = null; // To keep of selected Options, to be added to Option Singleton later

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tellermain);
        String Users[] = {"Bob","Joe","Kevin","Joe"};


        Button ManageFundsButton = (Button)findViewById(R.id.ManageFundsB);
        Button CloseButton = (Button)findViewById(R.id.CloseAccountB);
        Button SelectButton = (Button)findViewById(R.id.SelectB);



        final AutoCompleteTextView actv = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        actv.setAdapter(new ArrayAdapter<String>(this, R.layout.tellersearchdropdown, Users));



        // Button Actions Defined
        SelectButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
            String SelectedUser = actv.getText().toString();
            temp = SelectedUser;
                Toast.makeText(getApplicationContext(),
                        "SelectedUser is " +
                        SelectedUser,
                        Toast.LENGTH_LONG).show();
            }
        });

        ManageFundsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    // Testing
                    if (temp.equals("Joe")) {
                        Intent mfIntent = new Intent(TellerMain.this, ManageFundsTemplate.class);
                        startActivity(mfIntent);
                    }
                }
                catch (NullPointerException e)
                {
                    Toast.makeText(getApplicationContext(),
                            "Please Select a User First",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        CloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {

                }

                catch (NullPointerException e)
                {
                    Toast.makeText(getApplicationContext(),
                            "Please Select a User First",
                            Toast.LENGTH_LONG).show();
                }




            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.teller_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
