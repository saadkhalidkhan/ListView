package com.example.saadkhan.listview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Saad Khan on 13/03/2018.
 */

public class DataRecycle extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<String> User=new ArrayList<String>();
    ArrayList<String> Area=new ArrayList<String>();
    ArrayList<String> Country=new ArrayList<String>();
    public DataRecycle(Context context, ArrayList User, ArrayList Area,ArrayList Country){
        this.context = context;
        this.User = User;
        this.Area = Area;
        this.Country = Country;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.grid,parent,false);
        return new Items(view);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((Items)holder).name.setText(User.get(position));
        ((Items)holder).area.setText(Area.get(position));
        //String date1= DateFormat.getDateTimeInstance().format(new Date());
        ((Items)holder).country.setText(Country.get(position));
        ((Items)holder).press.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context,"Clicked at position " + position, Toast.LENGTH_SHORT).show();
                //Toast.makeText(context,((Items)holder).name.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return Area.size();
    }

    public class Items extends RecyclerView.ViewHolder{
        TextView name;
        TextView area;
        TextView country;
        Button press;
        public Items(View view) {
            super(view);
            country = (TextView) view.findViewById(R.id.country);
            name= (TextView) view.findViewById(R.id.name);
            area = (TextView) view.findViewById(R.id.area);
            press = (Button) view.findViewById(R.id.press);
        }
    }
}
