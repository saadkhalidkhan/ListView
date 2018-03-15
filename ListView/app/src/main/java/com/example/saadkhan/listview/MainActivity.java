package com.example.saadkhan.listview;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button submit;
    ListView listView;
    SharedPreferences preferences;
    ArrayList<String> user = new ArrayList<String>();
    ArrayList<String> pass = new ArrayList<String>();
    ArrayList<String> date  = new ArrayList<>();
    String userPattern;
    String passPattern;
    public int count = 1;
    public int total = 0;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userPattern = "[A-Za-z0-9.]+@[a-z0-9.]";
        passPattern ="[A-Za-z0-9]+[A-Za-z0-9]+[A-Za-z0-9]";

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);
        listView = (ListView) findViewById(R.id.listview);
        total = Integer.parseInt(getValuefromSharedPrefrences("count","0"));
        if(total != 0) {
            for (int i = 1; i <= total; i++) {
                    user.add(getValuefromSharedPrefrences("user"+i,"No User"));
                    pass.add(getValuefromSharedPrefrences("password"+i,"No Password"));
                    date.add(getValuefromSharedPrefrences("Date"+i,"No Date"));
                    count = Integer.parseInt(getValuefromSharedPrefrences("count", String.valueOf(0)));
                    data = new Data(MainActivity.this,user,pass,date);
                    listView.setAdapter(data);
                //Log.d("Shared Data", String.valueOf(total));
            }
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter User Name", Toast.LENGTH_LONG).show();
                }
                else if(password.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Password", Toast.LENGTH_LONG).show();
                }
                else{
                    String email = username.getEditableText().toString().trim();
                    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z.]+";
                    String pass = password.getEditableText().toString().trim();
                    String PassPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

                    if (email.matches(emailPattern) && pass.matches(PassPattern))
                    {
                        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_LONG).show();
                        String date1= DateFormat.getDateTimeInstance().format(new Date());
                        saveToSharedPrefrences("user"+(total + 1), username.getText().toString());
                        saveToSharedPrefrences("password"+(total + 1) , password.getText().toString());
                        saveToSharedPrefrences("Date" + (total + 1),date1);
                        saveToSharedPrefrences("count",String.valueOf(total + 1));
                        username.setText("");
                        password.setText("");
                        total = Integer.parseInt(getValuefromSharedPrefrences("count", String.valueOf(0)));
                        addToList();
                    }

                    else if(username.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(),"Enter User Name",Toast.LENGTH_LONG).show();

                    else if(password.getText().toString().equals(""))
                        Toast.makeText(getApplicationContext(),"Enter Password",Toast.LENGTH_LONG).show();

                    else if (!email.matches(emailPattern) )
                    {
                        Toast.makeText(getApplicationContext(),"invalid email address",Toast.LENGTH_SHORT).show();
                    }

                    else if (!pass.matches(PassPattern) )
                    {
                        Toast.makeText(getApplicationContext(),"invalid Password",Toast.LENGTH_SHORT).show();
                    }

                    //user.add(username.getText().toString()) ;
                    //pass.add( password.getText().toString());
                }
            }
        });

    }
    public void addToList(){
        user.add(getValuefromSharedPrefrences("user"+total,"No User"));
        pass.add(getValuefromSharedPrefrences("password"+total,"No Password"));
        date.add(getValuefromSharedPrefrences("Date"+total, "No Date"));
        count = Integer.parseInt(getValuefromSharedPrefrences("count", String.valueOf(0)));
        total = count;
        data = new Data(MainActivity.this,user,pass,date);
        listView.setAdapter(data);
    }


    public void saveToSharedPrefrences(String Key, String value){
        preferences = getSharedPreferences("ListView",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Key,value);
        editor.commit();

    }

    public String getValuefromSharedPrefrences(String key,String defaultValue){
        preferences = getSharedPreferences("ListView", Context.MODE_PRIVATE);
        return preferences.getString(key,defaultValue);
    }
}
