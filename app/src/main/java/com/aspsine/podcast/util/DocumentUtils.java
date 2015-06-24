package com.aspsine.podcast.util;

import com.aspsine.podcast.model.Page;
import com.aspsine.podcast.model.PodCast;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aspsine on 2015/6/24.
 */
public class DocumentUtils {

    public static Page getPage(Document document, boolean isParsePageInfo) {
        Page page = new Page();
        page.setIsParsePageInfo(isParsePageInfo);
        //page info
        if (isParsePageInfo) {
            Element liPage = document.select(".nav-pages-showing").first();
            Elements spans = liPage.getElementsByTag("span");
            page.setPageSize(Integer.valueOf(spans.get(1).text()));
            page.setPodCastNum(Integer.valueOf(spans.get(2).text()));
        }
        //list
        List<PodCast> podCasts = new ArrayList<PodCast>();
        Elements podCastDivs = document.getElementById("results-list").getElementsByClass("pc-results-box");
        for (Element divAlbum : podCastDivs) {
            PodCast podCast = new PodCast();
            Element aArtWork = divAlbum.getElementsByClass("pc-results-artwork").get(0).getElementsByTag("a").get(0);
            podCast.setHref(aArtWork.attr("href"));
            podCast.setArtwork(aArtWork.getElementsByTag("img").get(0).attr("src"));
            String name = divAlbum.getElementsByClass("pc-result-heading").get(0).getElementsByTag("a").get(0).text();
            podCast.setName(name);
            String lastUpdate = divAlbum.getElementsByClass("pc-result-episode-date").get(0).text();
            podCast.setLastUpdate(lastUpdate);
            String averageDuration = divAlbum.getElementsByClass("pc-result-episode-duration").get(0).text();
            podCast.setAverageDuration(averageDuration);
            String description = divAlbum.getElementsByClass("pc-results-description").get(0).text();
            podCast.setDescription(description);
            podCasts.add(podCast);
        }
        page.setPodCasts(podCasts);
        return page;
    }

}
