package com.example.pc.phone_book;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;

public class add extends AppCompatActivity {
    private final int GaALLERY_REQ_CODE = 1000;
    ImageView imgGallery;

    private Button foradd,gallery;
    private EditText editText1,editText2,editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText1=(EditText) findViewById(R.id.tv3);
        editText2=(EditText)findViewById(R.id.tv2);
        editText3=(EditText)findViewById(R.id.tv1);
        foradd=(Button) findViewById(R.id.buttonSave);


        foradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=  editText1.getText().toString();
                String s2=  editText2.getText().toString();
                String s3=  editText3.getText().toString();
                Intent it=new Intent(add.this,MainActivity.class);
                it.putExtra("key1",s1);
                setResult(1,it);
                it.putExtra("key2",s2);
                setResult(2,it);
                it.putExtra("key3",s3);
                setResult(3,it);
                finish();
            }
        });

    }


}
