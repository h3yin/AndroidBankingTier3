package com.example.androidbanking.Customer;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidbanking.MainActivity;
import com.example.androidbanking.R;
import com.example.model.UserSingleton;
import com.example.androidbanking.Customer.ViewStatement;


public class CustomerMain extends Activity {


    UserSingleton Bob = UserSingleton.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customermain);
        final LinearLayout Ll_Accounts = (LinearLayout) findViewById(R.id.dynamiclyCreated);
        final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);


        Spinner spinner = (Spinner) findViewById(R.id.spinnerDown);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.customeroptions_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
/*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if(parent.getSelectedItemPosition()==0)
                {
                    Intent viewIntent = new Intent(CustomerMain.this, ViewStatement.class);
                    startActivity(viewIntent);
                }
                if(parent.getSelectedItemPosition()==1)
                {
                        Intent transferIntent = new Intent(CustomerMain.this, CustomerManageFunds.class);
                        startActivity(transferIntent);
                        finish();
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        }); //Anon Class
        */


        Bob.setBobInfo();  // Initialize with user "Bob"
        // Create Bank Account Info
                for(int j=0;j< Bob.getnumOfAccounts();j++)
                {
                    // Create LinearLayout
                    LinearLayout ll = new LinearLayout(getApplicationContext());
                    ll.setOrientation(LinearLayout.HORIZONTAL);

                    // Create TextView
                    TextView product = new TextView(getApplicationContext());
                    product.setText(Bob.getSingleAccountType(j) + " Product"+j+"    "
                            );
                    ll.addView(product);

                    // Create TextView
                    TextView price = new TextView(getApplicationContext());
                    price.setText("  $"+"  "+ Bob.getSingleAccountValue(j));
                    ll.addView(price);

                    // Create Button
                    final Button btn = new Button(getApplicationContext());
                    // Give button an ID
                    btn.setId(j+1);
                    btn.setText("View Transactions");
                    // set the layoutParams on the button
                    btn.setLayoutParams(params);

                    final int index = j;
                    // Set click listener for button
                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {

                            Log.i("TAG", "index :" + index);
                            Toast.makeText(getApplicationContext(),
                                    "Clicked Button Index :" + index,
                                    Toast.LENGTH_LONG).show();

                            Toast.makeText(getApplicationContext(),
                                    "Login Error! User:" + index,
                                    Toast.LENGTH_LONG).show();

                            /*
                            Toast toast = new Toast(getApplicationContext());
                            Toast.makeText(getApplicationContext(), "TEXT HAS APPEARED", Toast.LENGTH_SHORT).show();
                            TextView newview = (TextView) toast.getView().findViewById(android.R.id.message);
                            toast.show();
                            */
                        }
                    });

                    //Add button to LinearLayout
                    ll.addView(btn);
                    //Add button to LinearLayout defined in XML
                    Ll_Accounts.addView(ll);

                }







                Toast.makeText(getApplicationContext(),
                        "Congrats! You've Won!",
                        Toast.LENGTH_LONG).show();




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.customer_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {           // Menu
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        super.onOptionsItemSelected(item);
        switch(item.getItemId()) {


            case R.id.TransferFunds:
                TransferFundsOption();
                break;
            case R.id.Logout:
                LogoutOption();
                break;
            case R.id.ViewStatement:
                ViewStatementOption();
                break;
        }

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void TransferFundsOption()
    {
        Intent transferIntent = new Intent(CustomerMain.this, CustomerManageFunds.class);
        startActivity(transferIntent);
        finish();
    }
    public void LogoutOption()
    {
        Intent mainIntent = new Intent(CustomerMain.this, MainActivity.class);
        startActivity(mainIntent);
        finish();
    }
    public void ViewStatementOption()
    {
        Intent viewIntent = new Intent(CustomerMain.this, ViewStatement.class);
        startActivity(viewIntent);
        finish();
    }

}
