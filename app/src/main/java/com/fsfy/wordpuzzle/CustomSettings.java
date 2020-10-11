package com.fsfy.wordpuzzle;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

public class CustomSettings {

    public static boolean isVibration;

    public static boolean isSound;

    private static Vibrator vibrator;
    public static void Vibration(final Context context, final Integer time) {
        if (isVibration) {
            if (vibrator == null) {
                vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(time, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                vibrator.vibrate(time);
            }
        }
    }

    public static MediaPlayer mediaPlayerClick;
    public static void loadClickSound(final Context context) {
        try {
            if (mediaPlayerClick == null) {
                mediaPlayerClick = MediaPlayer.create(context, R.raw.click);
            }

            if (isSound) {
                mediaPlayerClick.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
