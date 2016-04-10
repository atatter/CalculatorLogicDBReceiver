package com.aleks.calculatorlogicdbreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by aleks on 10/04/16.
 */
public class CustomReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Cutsom Broadcast receiver", Toast.LENGTH_LONG).show();
    }
}
