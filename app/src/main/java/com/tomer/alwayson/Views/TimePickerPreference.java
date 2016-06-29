package com.tomer.alwayson.Views;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.TimePicker;

import com.tomer.alwayson.Prefs;
import com.tomer.alwayson.R;

public class TimePickerPreference extends Dialog {

    public TimePickerPreference(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.time_picker_dialog);
        Prefs prefs = new Prefs(getContext());
        prefs.apply();
        findViewById(R.id.dialog_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePicker startTimePicker = (TimePicker) findViewById(R.id.timepicker_start);
                TimePicker endTimePicker = (TimePicker) findViewById(R.id.timepicker_end);
                endTimePicker.setIs24HourView(DateFormat.is24HourFormat(getContext()));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Log.d("DIALOG START", startTimePicker.getHour() + ":" + startTimePicker.getMinute());
                    Log.d("DIALOG START", endTimePicker.getHour() + ":" + startTimePicker.getMinute());
                }
            }
        });
    }
}

