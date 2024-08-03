package com.example.pc.todo_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pc on 8/25/2022.
 */

class CustomAdaptor extends BaseAdapter{

    List<String> time,title,des;
    Context context;
    private LayoutInflater lf;

    public CustomAdaptor(MainActivity mainActivity, List<String> time, List<String> title, List<String> des) {
            context=mainActivity;
            this.time=time;
            this.title=title;
            this.des=des;
    }

    @Override
    public int getCount() {
        return time.size();
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

        t1.setText(time.get(position));
        t2.setText(title.get(position));
        t3.setText(des.get(position));
        return convertView;
    }
}
