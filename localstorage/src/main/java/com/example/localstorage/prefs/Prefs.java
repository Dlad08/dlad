package com.example.localstorage.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {
    private static final String EMPLOYEE_USER="employee";
    private static final String EMPLOYEE_Name="employee_name";
    private static final String EMPLOYEE_USERNAME="employee_username";

    public static void saveEmployeeName(Context context,String name){
        SharedPreferences sharedPreferences=context.getSharedPreferences(EMPLOYEE_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(EMPLOYEE_Name,name).apply();
    }
    public static String getEmployeeName (Context context){
      SharedPreferences sharedPreferences=
      context.getSharedPreferences(EMPLOYEE_USER,Context.MODE_PRIVATE);
      return sharedPreferences.getString(EMPLOYEE_Name,"null");
    }

    public static void saveEmployeeUserName(Context context,String username){
        SharedPreferences sharedPreferences=
                context.getSharedPreferences(EMPLOYEE_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(EMPLOYEE_USERNAME,username).apply();
    }
    public static String getEmployeeUsernameName (Context context){
        SharedPreferences sharedPreferences=
                context.getSharedPreferences(EMPLOYEE_USER,Context.MODE_PRIVATE);
        return sharedPreferences.getString(EMPLOYEE_USERNAME,"null");
    }
}
