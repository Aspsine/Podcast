package com.aspsine.podcast.ui.main.podcast;

import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewModel;

/**
 * Created by zhangfan10 on 16/9/30.
 */

public class MyPodcastViewModel implements ItemViewModel{

    private Podcast podcast;

    public MyPodcastViewModel() {
        this.podcast = new Podcast();
    }

    public String getId() {
        return podcast.getId();
    }

    public void setId(String id) {
        podcast.setId(id);
    }

    public String getName() {
        return podcast.getName();
    }

    public void setName(String name) {
        podcast.setName(name);
    }

    public String getArtwork() {
        return podcast.getArtwork();
    }

    public void setArtwork(String artwork) {
        podcast.setArtwork(artwork);
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        podcast.setLastUpdate(lastUpdateTime);
    }

    public String getLastUpdateTime() {
        return podcast.getLastUpdate();
    }
}
