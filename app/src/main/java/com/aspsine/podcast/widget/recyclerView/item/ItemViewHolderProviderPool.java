package com.aspsine.podcast.widget.recyclerView.item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class ItemViewHolderProviderPool {
    public static final String TAG = "ItemViewHolderProviderPool";

    private static List<Class<? extends ItemViewModel>> sItemViewModelClasses = new ArrayList<>();

    private static List<ItemViewHolderProvider> sProviders = new ArrayList<>();

    public static void register(Class<? extends ItemViewModel> clazz, ItemViewHolderProvider provider) {
        if (sItemViewModelClasses.contains(clazz) || sProviders.contains(provider)) {
            throw new IllegalArgumentException("Already exist:" + clazz.getName());
        } else {
            sItemViewModelClasses.add(clazz);
            sProviders.add(provider);
        }
    }

    public static ItemViewHolderProvider get(int viewType) {
        return sProviders.get(viewType);
    }

    public static int getItemViewType(Class<? extends ItemViewModel> clazz) {
        return indexOfItemViewModelClazz(clazz);
    }

    public static Class<? extends ItemViewModel> getItemViewModelClass(int type) {
        return sItemViewModelClasses.get(type);
    }

    private static int indexOfItemViewModelClazz(Class<? extends ItemViewModel> clazz) {
        return sItemViewModelClasses.indexOf(clazz);
    }

}
