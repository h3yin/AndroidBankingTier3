package com.example.model;

import android.os.Bundle;


/**
 * Created by admin on 11/6/14.
 */

/*
GWModelFactory()
        {
        GWModel createModel(Bundle b) // To Wrap Existing Bundle
        {
        return GWModel(Bundle b);
        };


        GWModel createModel(String Username, String Password)
        // First creation, does work, returns null else
        {
        GWModel newModel;    // Code for checking Query if keys match

        if ((newModel = GWModel(Username,Password)) == False)
        {return null;}
        else { return newModel;}
        }

        }

        */
public class GWModel
{
Bundle GWBundle;
final String KEY_NAME = "name";
final String KEY_EMAIL = "email";
final String KEY_PASSWORD = "password";
final String KEY_SSN = "socialsecurity";
final String KEY_DOB = "dateofbirth";
final String KEY_SAVINGS = "SavingsId";
final String KEY_CHECKINGS = "CheckingsId";
final String KEY_UNIQUE = "UniqueId";
        //final String KEY_PIN;
        //final String KEY_SECQ;




        String UserQuery = "Insert here.";
        String PWQuery = "Insert here.";
        void GMModel (Bundle b)
        {
        GWBundle = new Bundle();
        GWBundle.putString(KEY_NAME, b.getString(KEY_NAME));
        GWBundle.putString(KEY_EMAIL,b.getString(KEY_EMAIL));
        GWBundle.putString(KEY_PASSWORD,b.getString(KEY_PASSWORD));
        GWBundle.putString(KEY_SSN,b.getString(KEY_SSN));
        GWBundle.putString(KEY_DOB,b.getString(KEY_DOB));
        GWBundle.putString(KEY_UNIQUE,b.getString(KEY_UNIQUE));
        GWBundle.putString(KEY_SAVINGS,b.getString(KEY_SAVINGS));
        GWBundle.putString(KEY_CHECKINGS,b.getString(KEY_CHECKINGS));

        }

        Boolean GMModel(String user,String password) {

            Boolean queryTrue = false;
            //Query info ---
            //if successful, copy Bundle, set queryTrue to true
            //else, don't extract and just return queryTrue
            GWBundle = new Bundle();
/*
        GWBundle.putString(KEY_NAME, ...
        GWBundle.putString(KEY_EMAIL, ...
        GWBundle.putString(KEY_PASSWORD,...
        GWBundle.putString(KEY_SSN,...
        GWBundle.putString(KEY_DOB,...
        GWBundle.putString(KEY_UNIQUE,...
        GWBundle.putString(KEY_SAVINGS,...
        GWBundle.putString(KEY_CHECKINGS,...
*/
        // else if not true
                return queryTrue;
        }


        Bundle getBundle() {
        return GWBundle;
        };
        //void Refresh();

      /*  boolean addBalance( String accnt, String user, String amount)
        {
        // Query and update by amount.(Transfer?)
        // If Query says insufficient, then return false
        }
    */
        //transerTo( String accnt, String user, String amount)



        }