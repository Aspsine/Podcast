package com.aspsine.podcast.data.utils;

import com.aspsine.podcast.data.entity.EpisodeEntity;
import com.aspsine.podcast.data.entity.PageEntity;
import com.aspsine.podcast.data.entity.PodcastEntity;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/6/24.
 */
public class DocumentUtils {

    public static PageEntity getPage(Document document, boolean isParsePageInfo) {
        PageEntity page = new PageEntity();
        page.setIsParsePageInfo(isParsePageInfo);
        //page info
        if (isParsePageInfo) {
            Element liPage = document.select(".nav-pages-showing").first();
            Elements spans = liPage.getElementsByTag("span");
            page.setPageSize(Integer.valueOf(spans.get(1).text()));
            page.setPodCastNum(Integer.valueOf(spans.get(2).text()));
        }
        //list
        List<PodcastEntity> podcasts = new ArrayList<PodcastEntity>();
        Elements podCastDivs = document.getElementById("results-list").getElementsByClass("pc-results-box");
        for (Element divAlbum : podCastDivs) {
            PodcastEntity podcast = new PodcastEntity();
            Element aArtWork = divAlbum.getElementsByClass("pc-results-artwork").get(0).getElementsByTag("a").get(0);
            String href = aArtWork.attr("href");
            podcast.setId(href.substring("http://www.bbc.co.uk/programmes/".length(), href.indexOf("/episodes/downloads")));
            podcast.setHref(href);
            podcast.setArtwork(aArtWork.getElementsByTag("img").get(0).attr("src"));
            String station = divAlbum.getElementsByClass("pc-results-network").get(0).getElementsByTag("a").get(0).text();
            podcast.setStation(station);
            String name = divAlbum.getElementsByClass("pc-result-heading").get(0).getElementsByTag("a").get(0).text();
            podcast.setName(name);
            String lastUpdate = divAlbum.getElementsByClass("pc-result-episode-date").get(0).text();
            podcast.setLastUpdate(lastUpdate);
            String averageDuration = divAlbum.getElementsByClass("pc-result-episode-duration").get(0).text();
            podcast.setAverageDuration(averageDuration);
            String description = divAlbum.getElementsByClass("pc-results-description").get(0).text();
            podcast.setDescription(description);
            podcasts.add(podcast);
        }
        page.setPodcasts(podcasts);
        return page;
    }


}
