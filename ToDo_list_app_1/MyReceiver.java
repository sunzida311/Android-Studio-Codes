package com.example.pc.todo_list;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

/**
 * Created by pc on 10/16/2022.
 */

public class MyReceiver extends BroadcastReceiver {
    MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
        mp.setLooping(true);
        mp.start();
    }
}
