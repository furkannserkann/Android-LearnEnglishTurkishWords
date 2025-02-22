package com.fsfy.learnenglishturkishwords;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.os.VibratorManager;

public class CustomSettings {

    public static boolean isVibration;

    public static boolean isSound;

    private static Vibrator vibrator;
    public static void Vibration(final Context context, final Integer time) {
        try {
            if (isVibration) {
                if (vibrator == null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        VibratorManager vibratorManager = (VibratorManager) context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE);
                        if (vibratorManager != null) {
                            vibrator = vibratorManager.getDefaultVibrator();
                        }
                    } else {
                        vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                    }
                }

                if (vibrator != null) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        vibrator.vibrate(VibrationEffect.createOneShot(time, VibrationEffect.DEFAULT_AMPLITUDE));
                    } else {
                        vibrator.vibrate(time);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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
