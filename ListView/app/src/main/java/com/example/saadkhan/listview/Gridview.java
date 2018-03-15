package com.example.saadkhan.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Gridview extends AppCompatActivity {

    GridView gridView;
    ArrayList<String> user=new ArrayList<String>();
    ArrayList<String> pass=new ArrayList<String>();
    EditText username;
    EditText password;
    Button submit;
    Data data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gridView = (GridView) findViewById(R.id.grid);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        submit = (Button) findViewById(R.id.submit);

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
                    user.add(username.getText().toString()) ;
                    pass.add( password.getText().toString());
                   // data = new Data(Gridview.this,user,pass);
                    gridView.setAdapter(data);

                }
            }
        });
    }
}
