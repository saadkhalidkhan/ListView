package com.example.saadkhan.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Recycle extends AppCompatActivity {

    RecyclerView recyclerView;



    ArrayList<String> User=new ArrayList<String>();
    ArrayList<String> Area=new ArrayList<String>();
    ArrayList<String> Country=new ArrayList<String>();
    EditText name;
    EditText area;
    EditText country;
    Button submit;
    DataRecycle data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        recyclerView = (RecyclerView) findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));

        name = (EditText)findViewById(R.id.name);
        area = (EditText)findViewById(R.id.area);
        country = (EditText) findViewById(R.id.country);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Name", Toast.LENGTH_LONG).show();
                }
                else if(area.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Area", Toast.LENGTH_LONG).show();
                }
                else if(country.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Enter Country", Toast.LENGTH_LONG).show();
                }
                else{
                    User.add(name.getText().toString()) ;
                    Area.add( area.getText().toString());
                    Country.add( country.getText().toString());
                    name.setText("");
                    area.setText("");
                    country.setText("");
                    data = new DataRecycle(Recycle.this,User,Area,Country);
                    recyclerView.setAdapter(data);

                }
            }
        });
    }
}
