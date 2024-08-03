package com.example.pc.todo;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

public class add extends AppCompatActivity {

    private Button foradd,settime;
    private EditText editText1,editText2,editText3;
    private TimePicker tm;
    private TimePickerDialog t;
    private int ch,cm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editText3=(EditText) findViewById(R.id.taskTime);
        editText1=(EditText)findViewById(R.id.addTaskTitle);
        editText2=(EditText)findViewById(R.id.addTaskDescription);
        foradd=(Button) findViewById(R.id.addTask);
        settime=(Button) findViewById(R.id.buttonId2);
        settime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tm =new TimePicker(add.this);
                int currentHour=tm.getHour();
                int  currentMinute=tm.getMinute();
                t=new TimePickerDialog(add.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            ch=hourOfDay;
                            cm=minute;
                            editText3.setText(hourOfDay + ":"+ minute);
                    }
                },currentHour,currentMinute,true);
                t.show();
            }
        });

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
                it.putExtra("key4",Integer.toString(ch));
                setResult(4,it);
                it.putExtra("key5",Integer.toString(cm));
                setResult(5,it);
                finish();
            }
        });
    }
}
