package com.aspsine.podcast.ui.base;

/**
 * Created by aspsine on 16/9/11.
 */

public interface BaseView<T extends BasePresenter> {

    void setPresenter(T presenter);
}