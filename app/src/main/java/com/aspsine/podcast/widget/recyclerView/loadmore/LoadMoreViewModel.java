package com.aspsine.podcast.widget.recyclerView.loadmore;

import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by aspsine on 16/10/22.
 */

public class LoadMoreViewModel implements ItemViewModel {

    private State state = State.Empty;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
