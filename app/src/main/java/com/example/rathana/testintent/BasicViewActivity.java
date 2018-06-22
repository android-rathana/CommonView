package com.example.rathana.testintent;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rathana.testintent.dialog.DatePickerDialog;
import com.example.rathana.testintent.dialog.TimePicker;

public class BasicViewActivity extends AppCompatActivity implements
        TimePicker.OnTimeListener,DatePickerDialog.OnDateListener
{

    CheckBox chJava,chAndroid,chiOS;
    RadioGroup rdG;
    TextView tvTime,tvDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_view);

        chJava=findViewById(R.id.chJava);
        rdG=findViewById(R.id.rdG);
        tvDate=findViewById(R.id.pkDate);
        tvTime=findViewById(R.id.pkTime);

        chJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    showMessage("java is checked");
                else
                    showMessage("java is unchecked");
            }
        });

        rdG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               RadioButton rd=findViewById(checkedId);
               if(rd.isChecked())
                   showMessage(rd.getText().toString());

            }
        });


        tvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker dialog=new TimePicker();
                dialog.show(getFragmentManager(),"TIME");
            }
        });
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog().show(getFragmentManager(),"DATE");
            }
        });

    }

    void showMessage(String sms){
        Toast.makeText(this, ""+sms, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSetDate(String date) {
        tvDate.setText(date);
    }

    @Override
    public void onTimeSet(String time) {
        tvTime.setText(time);
    }
}
