package com.aspsine.podcast.widget.recyclerView.item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aspsine on 16/9/17.
 */

public class MultiTypeManager {
    public static final String TAG = "ItemViewHolderFactoryManager";

    private List<Class<? extends ItemViewModel>> sItemViewModelClasses = new ArrayList<>();

    private List<ItemViewHolderFactory> sFactories = new ArrayList<>();

    public void register(Class<? extends ItemViewModel> clazz, ItemViewHolderFactory factory) {
        if (sItemViewModelClasses.contains(clazz) || sFactories.contains(factory)) {
            throw new IllegalArgumentException("Already exist:" + clazz.getName());
        } else {
            sItemViewModelClasses.add(clazz);
            sFactories.add(factory);
        }
    }

    public ItemViewHolderFactory get(int viewType) {
        return sFactories.get(viewType);
    }

    public int getItemViewType(Class<? extends ItemViewModel> clazz) {
        return indexOfItemViewModelClazz(clazz);
    }

    public Class<? extends ItemViewModel> getItemViewModelClass(int type) {
        return sItemViewModelClasses.get(type);
    }

    private int indexOfItemViewModelClazz(Class<? extends ItemViewModel> clazz) {
        return sItemViewModelClasses.indexOf(clazz);
    }
}
