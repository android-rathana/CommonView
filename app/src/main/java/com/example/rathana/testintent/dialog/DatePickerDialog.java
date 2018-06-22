package com.example.rathana.testintent.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.widget.DatePicker;

import java.util.Calendar;
import java.util.Date;

public class DatePickerDialog extends DialogFragment implements android.app.DatePickerDialog.OnDateSetListener{
    private DatePickerDialog.OnDateListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener= (OnDateListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar calendar=Calendar.getInstance();
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        int month=calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);

        android.app.DatePickerDialog datePickerDialog=new android.app.DatePickerDialog(getActivity(),this,
                dayOfMonth,month,year);

        DatePicker picker=datePickerDialog.getDatePicker();
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add( Calendar.YEAR, -20 ) ;// Subtract 6 months
        long minDate = c.getTime().getTime(); // Twice!
        picker.setMinDate(minDate);

        c.add(Calendar.YEAR,20);
        long maxDate = c.getTime().getTime();
        picker.setMaxDate(maxDate);

        return datePickerDialog;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        listener.onSetDate(dayOfMonth+"-"+month+"-"+year);
    }

    public interface OnDateListener{
        void onSetDate(String date);
    }
}
