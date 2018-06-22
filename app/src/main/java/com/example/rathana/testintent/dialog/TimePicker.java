package com.example.rathana.testintent.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.format.DateFormat;

import java.util.Calendar;

public class TimePicker extends DialogFragment implements TimePickerDialog.OnTimeSetListener{
    private OnTimeListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.listener=(OnTimeListener) context;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar=Calendar.getInstance();
        int h=calendar.get(Calendar.HOUR);
        int mn=calendar.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),this,h,mn,
                DateFormat.is24HourFormat(getActivity()));
    }

    @Override
    public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
        listener.onTimeSet(hourOfDay+":"+minute);
    }

    public interface OnTimeListener{
        void onTimeSet(String time);
    }
}
