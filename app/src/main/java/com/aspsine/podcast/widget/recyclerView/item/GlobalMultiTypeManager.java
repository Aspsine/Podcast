package com.aspsine.podcast.widget.recyclerView.item;

/**
 * Created by aspsine on 16/10/29.
 */

public class GlobalMultiTypeManager {

    private static MultiTypeManager sMultiTypeManager = new MultiTypeManager();

    public static void register(Class<? extends ItemViewModel> clazz, ItemViewHolderFactory factory) {
        sMultiTypeManager.register(clazz, factory);
    }

    public static ItemViewHolderFactory get(int viewType) {
        return sMultiTypeManager.get(viewType);
    }

    public static int getItemViewType(Class<? extends ItemViewModel> clazz) {
        return sMultiTypeManager.getItemViewType(clazz);
    }

    public static Class<? extends ItemViewModel> getItemViewModelClass(int type) {
        return sMultiTypeManager.getItemViewModelClass(type);
    }

    public static MultiTypeManager getMultiTypeManager() {
        return sMultiTypeManager;
    }
}
