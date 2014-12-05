package com.example.androidbanking.Customer;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidbanking.R;


public class ViewStatement extends Activity {

    //private String[] date_and_time= {"1/1", "1/2","1/3","1/4","1/5"};
    //private int[] amount = {-330, 73, -25, -21, 9};
    //private int[] balance = {1670, 1743, 1718, 1697, 1706 };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
         String spacing = "        ";
         String[] date_and_time= {"1/1", "1/2","1/3","1/4","1/5"};
         int[] amount = {-330, 73, -25, -21, 9};
         int[] balance = {1670, 1743, 1718, 1697, 1706 };


        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewstatement);

        final LinearLayout L_DateColumn = (LinearLayout) findViewById(R.id.DateColumn);
        final LinearLayout L_AmountColumn = (LinearLayout) findViewById(R.id.AmountColumn);
        final LinearLayout L_BalanceColumn = (LinearLayout) findViewById(R.id.BalanceColumn);
        //final LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        //        ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        for( int i=0; i < 5; i++)
        {
            //LinearLayout ll = new LinearLayout(getApplicationContext());
            //ll.setOrientation(LinearLayout.HORIZONTAL);

          // Create TextView
          TextView date = new TextView(getApplicationContext());
          date.setText(date_and_time[i] + " " );
          L_DateColumn.addView(date);

          // Create TextView
          TextView myamount = new TextView(getApplicationContext());
            myamount.setText("  $"+ amount[i] );
          L_AmountColumn.addView(myamount);

          // Create TextView
          TextView mybalance = new TextView(getApplicationContext());
          mybalance.setText("  $"+ balance[i]);
          L_BalanceColumn.addView(mybalance);

          //Ll_Accounts.addView(ll);
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_statement, menu);
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
