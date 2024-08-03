package com.example.pc.autocomplete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView=(AutoCompleteTextView) findViewById(R.id.auto);
        String [] s= getResources().getStringArray(R.array.country);
        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,s);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(ad);

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String c=autoCompleteTextView.getText().toString();
                Toast.makeText(MainActivity.this,"Text : :"+c,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
