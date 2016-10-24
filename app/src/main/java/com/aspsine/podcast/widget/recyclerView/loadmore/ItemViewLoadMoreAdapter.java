package com.aspsine.podcast.widget.recyclerView.loadmore;

import android.support.annotation.Nullable;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by aspsine on 16/10/22.
 */

public class ItemViewLoadMoreAdapter<ViewModel extends ItemViewModel> extends ItemViewAdapter<ViewModel>{

    private LoadMoreViewModel loadMoreViewModel = new LoadMoreViewModel();

    public ItemViewLoadMoreAdapter() {
        super();
    }

    @Override
    public void setList(List<ViewModel> itemViewModels) {
        List<ViewModel> models = new ArrayList<>();
        for (ViewModel viewModel : itemViewModels){
            models.add(viewModel);
        }
        models.add((ViewModel) loadMoreViewModel);
        super.setList(models);
    }

    @Override
    public void append(List<ViewModel> itemViewModels) {
        ViewModel loadMoreViewModel = getLoadMoreViewModel();
        if (loadMoreViewModel != null) {
            int index = getList().indexOf(loadMoreViewModel);
            getList().addAll(index, itemViewModels);
            notifyItemRangeInserted(index, itemViewModels.size());
        }else {
            super.append(itemViewModels);
        }
    }

    @Nullable
    private ViewModel getLoadMoreViewModel() {
        List<ViewModel> viewModels = getList();
        for (ViewModel viewModel : viewModels) {
            if (viewModel instanceof LoadMoreViewModel) {
                return viewModel;
            }
        }
        return null;
    }

    public void setState(State state) {
        final ViewModel viewModel = getLoadMoreViewModel();
        if (viewModel != null){
            int index = getList().indexOf(viewModel);
            final LoadMoreViewModel loadMoreViewModel = (LoadMoreViewModel) viewModel;
            loadMoreViewModel.setState(state);
            notifyItemChanged(index);
        }
    }
}
