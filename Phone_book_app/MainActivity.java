package com.example.pc.phone_book;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    List<String> name, mob, ad, image;
    private ListView listView;
    private Button button1;
    private Intent i;
    private String s, ss, sss, txx, tyy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        listView = (ListView) findViewById(R.id.listViewId);
        button1 = (Button) findViewById(R.id.buttonId1);


        name = new ArrayList<String>();
        mob = new ArrayList<String>();
        ad = new ArrayList<String>();
        image = new ArrayList<String>();


        final CustomAdaptor adaptor = new CustomAdaptor(MainActivity.this, name, mob, ad);
        listView.setAdapter((ListAdapter) adaptor);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(MainActivity.this, add.class);
                startActivityForResult(i, 1);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                final int x=position;
                System.out.println(position);
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete Item")
                        .setMessage("Do you wanna Delete this item")
                        .setPositiveButton("Delete",new DialogInterface.OnClickListener(){

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                name.remove(position);
                                mob.remove(position);
                                ad.remove(position);
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

            name.add(sss);
            mob.add(s);
            ad.add(ss);
           Toast.makeText(MainActivity.this,"Item Added to ListView",Toast.LENGTH_SHORT).show();
        }

    }


}
