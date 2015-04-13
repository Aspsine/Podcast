package com.aspsine.podcast.util;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by aspsine on 15-4-13.
 */

public class FileUtils {

    private static final String HTTP_CACHE_DIR = "http";

    public static final File getHttpCacheDir(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            return new File(context.getExternalCacheDir(), HTTP_CACHE_DIR);
        }
        return new File(context.getCacheDir(), HTTP_CACHE_DIR);
    }
}
