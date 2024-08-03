package com.example.pc.todo_list;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> time,title,des;
    List<Integer>wh,wm;
    private ListView listView;
    private Button button1;
    private ImageButton reload;
    private Intent i;
    private String s,ss,sss,txx,tyy;
    private TimePicker tm;
    long x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listViewId);
        button1=(Button) findViewById(R.id.buttonId1);
        reload=(ImageButton) findViewById(R.id.refresh);

        time=new ArrayList<String>();
        title=new ArrayList<String>();
        des=new ArrayList<String>();
        wh=new ArrayList<Integer>();
        wm=new ArrayList<Integer>();

        final CustomAdaptor adaptor=new CustomAdaptor(MainActivity.this,time,title,des);
        listView.setAdapter(adaptor);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=new Intent(MainActivity.this,add.class);
                startActivityForResult(i,1);
            }
        });
        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker tp=new TimePicker(MainActivity.this);
                int h=tp.getHour();
                int m=tp.getMinute();
                System.out.println("m : "+m);
                for(int i=1;i<=time.size();i++){
                    if(wh.get(i-1)<h || (wh.get(i-1)==h&&wm.get(i-1)<m)){
                        time.remove(i-1);
                        title.remove(i-1);
                        des.remove(i-1);
                        wh.remove(i-1);
                        wm.remove(i-1);
                        adaptor.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this,"Item removed from ListView",Toast.LENGTH_SHORT).show();
                        i--;
                    }
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final int x=position;
                System.out.println(position);
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.icon)
                        .setTitle("Delete Item")
                        .setMessage("Do you wanna Delete this item")
                        .setPositiveButton("Delete",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                time.remove(position);
                                title.remove(position);
                                des.remove(position);
                                adaptor.notifyDataSetChanged();
                                Toast.makeText(MainActivity.this,"Item removed from ListView",Toast.LENGTH_SHORT).show();

                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                return true;
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            s=data.getStringExtra("key1").toString();
            ss=data.getStringExtra("key2").toString();
            sss=data.getStringExtra("key3").toString();
            txx=data.getStringExtra("key4").toString();
            tyy=data.getStringExtra("key5").toString();
            x=data.getLongExtra("key6",0);
            //System.out.println("!!!???I am the long value ::: "+x);

            time.add(sss);
            title.add(s);
            des.add(ss);
            wh.add(Integer.parseInt(txx.toString()));
            wm.add(Integer.parseInt(tyy.toString()));
            Toast.makeText(MainActivity.this,"Item Added to ListView",Toast.LENGTH_SHORT).show();
            if(wh.size()>1){
                for(int i=wh.size()-1;i>0;i--){
                    for(int j=i-1;j>=0;j--){
                        if(wh.get(i)<wh.get(j)||(wh.get(i)==wh.get(j)&&wm.get(i)<wm.get(j))){
                            Collections.swap(time, i, j);
                            Collections.swap(title, i, j);
                            Collections.swap(des, i, j);
                            Collections.swap(wh, i, j);
                            Collections.swap(wm, i, j);
                        }
                    }

                }
            }
        }
    }
}
