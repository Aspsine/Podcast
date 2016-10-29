package com.aspsine.podcast.util;

import android.util.Log;

/**
 * Created by aspsine on 16/10/28.
 */

public class BBCImageUtils {

    private static final String BASE_IMAGE_URL = "http://ichef.bbci.co.uk/images/ic/";

    public static String getImageUrl(String imageUrl, int size) {
        String imageName = imageUrl.substring(imageUrl.lastIndexOf("/"));
        int properSize = (size / 16 + 1) * 16;
        if (properSize > 1920) {
            properSize = 1920;
        }
        Log.i("Size", properSize + "");
        return BASE_IMAGE_URL + properSize + "x" + properSize + imageName;
    }


}
