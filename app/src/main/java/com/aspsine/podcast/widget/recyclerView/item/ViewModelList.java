package com.aspsine.podcast.widget.recyclerView.item;

import java.util.List;

/**
 * Created by aspsine on 16/10/22.
 */

public interface ViewModelList<T extends ItemViewModel, Ts extends List<T>> extends ItemViewModel, List<T>{

}
