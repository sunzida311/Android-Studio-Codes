package com.example.pc.phone_book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pc on 8/29/2022.
 */

public class CustomAdaptor extends BaseAdapter{

    List<String> name,mob,ad;
    Context context;
    private LayoutInflater lf;

    public CustomAdaptor(MainActivity mainActivity, List<String> name, List<String> mob, List<String> ad) {
        context=mainActivity;
        this.name=name;
        this.mob=mob;
        this.ad=ad;
    }

    @Override
    public int getCount() {
        return name.size();
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
        if(convertView==null){
            lf=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=lf.inflate(R.layout.list,parent,false);
        }
        TextView t1=(TextView) convertView.findViewById(R.id.textView1);
        TextView t2=(TextView) convertView.findViewById(R.id.textView2);
        TextView t3=(TextView) convertView.findViewById(R.id.textView3);

        t1.setText(name.get(position));
        t2.setText(mob.get(position));
        t3.setText(ad.get(position));
        return convertView;
        }
}
