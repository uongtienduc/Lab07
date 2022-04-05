package com.example.myapplication;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private ArrayList<Contact> contactsList;
    private Context context;

    public Adapter(ArrayList<Contact> list, Context cont){
        this.contactsList = list;
        this.context = cont;
    }

    @Override
    public int getCount() {
        return this.contactsList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contactsList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if(convertView == null){
            LayoutInflater inf = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.activity_main, null);

            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.name);
            holder.phonenumber = convertView.findViewById(R.id.phonenumber);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder)convertView.getTag();
        }

        Contact stu = contactsList.get(position);

        holder.name.setText(stu.getName());
        holder.phonenumber.setText(stu.getPhoneNumber());

        return convertView;
    }

    private static class ViewHolder{
        public TextView name;
        public TextView phonenumber;
    }

}
