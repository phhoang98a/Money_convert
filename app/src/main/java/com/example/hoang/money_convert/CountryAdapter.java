package com.example.hoang.money_convert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends BaseAdapter {

    Context context;
    int myLayout;
    List<Country> arrayList;

    public CountryAdapter(Context context, int myLayout, List<Country> arrayList) {
        this.context = context;
        this.myLayout = myLayout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(myLayout,null);
        TextView txtName = (TextView)convertView.findViewById(R.id.txtName);
        ImageView imageView = (ImageView)convertView.findViewById(R.id.imageView);

        txtName.setText(arrayList.get(position).Name);
        imageView.setImageResource(arrayList.get(position).Image);

        return convertView;
    }
}
