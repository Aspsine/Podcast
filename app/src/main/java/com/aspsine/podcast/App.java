package com.aspsine.podcast;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Aspsine on 2015/4/13.
 */
public class App extends Application{
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        CrashHandler.getInstance(getApplicationContext());
    }

    public static Context getContext(){
        return context;
    }
}
