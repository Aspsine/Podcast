package com.aspsine.podcast.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Aspsine on 2015/4/17.
 */
public class UIUtils {
    public static final View inflate(int layoutId, ViewGroup parent){
         return LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
    }
}
