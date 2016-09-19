package com.aspsine.podcast.ui.featured.item.tag;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

import java.util.List;

/**
 * Created by zhangfan10 on 16/9/18.
 */

public class TagListViewModel implements ItemViewModel{
    private List<TagViewModel> tagViewModels;

    public List<TagViewModel> getTagViewModels() {
        return tagViewModels;
    }

    public void setTagViewModels(List<TagViewModel> tagViewModels) {
        this.tagViewModels = tagViewModels;
    }
}
