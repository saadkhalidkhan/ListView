package com.example.saadkhan.listview;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Saad Khan on 13/03/2018.
 */

public class Data extends BaseAdapter {
    Context context;
    ArrayList<String> userName=new ArrayList<String>();
    ArrayList<String> pass=new ArrayList<String>();
    ArrayList<String> dateArray = new ArrayList<String>();
    LayoutInflater layoutInflater;
    TextView username;
    TextView password;
    TextView date;

    public Data(Context context, ArrayList userName, ArrayList pass, ArrayList date){
        this.context = context;
        this.userName = userName;
        this.pass = pass;
        this.dateArray = date;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return userName.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = layoutInflater.inflate(R.layout.list,viewGroup,false);
        }
        date = (TextView) view.findViewById(R.id.date);
        username = (TextView) view.findViewById(R.id.username);
        password = (TextView) view.findViewById(R.id.password);
       // Date today = Calendar.getInstance().getTime();//getting date
        //SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");//formating according to my need
        //String date1 = formatter.format(today);
        String date1= DateFormat.getDateTimeInstance().format(new Date());
        date.setText(dateArray.get(i));
        username.setText(userName.get(i));
        password.setText(pass.get(i));
        return view;
    }

}
