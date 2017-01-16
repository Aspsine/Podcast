package com.aspsine.podcast.data.network;

import android.util.Log;

import com.aspsine.podcast.data.entity.CategoryEntity;
import com.aspsine.podcast.data.entity.EpisodeEntity;
import com.aspsine.podcast.data.entity.PageEntity;
import com.aspsine.podcast.data.entity.PodcastEntity;
import com.aspsine.podcast.data.entity.StationEntity;
import com.aspsine.podcast.data.rss.itunes.ItunesChannelRssReader;
import com.aspsine.podcast.data.rss.itunes.model.ItunesChannel;
import com.aspsine.podcast.data.rss.itunes.model.ItunesItem;
import com.aspsine.podcast.data.utils.DocumentUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import rx.Observable;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class RestApiImpl implements RestApi {

    private static final String BASE_URL = "http://www.bbc.co.uk";

    @Override
    public Observable<List<EpisodeEntity>> getEpisodes(String podcastId) {
        final String url = BASE_URL + "/programmes/" + podcastId + "/episodes/downloads";
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.string(request).flatMap(new Func1<String, Observable<List<EpisodeEntity>>>() {
            @Override
            public Observable<List<EpisodeEntity>> call(String s) {
                Document document = Jsoup.parse(s);

                int page = DocumentUtils.getPageNum(document);
                final List<EpisodeEntity> episodeEntities0 = DocumentUtils.getEpisodes(document);
                if (page <= 1) {
                    return Observable.just(episodeEntities0);
                }
                return Observable.range(2, page - 1)
                        .flatMap(new Func1<Integer, Observable<List<EpisodeEntity>>>() {
                            @Override
                            public Observable<List<EpisodeEntity>> call(Integer integer) {
                                Log.i("TAG", "pageIndex = " + integer);
                                final Request request1 = new Request.Builder().url(url + "?page=" + integer).get().build();
                                return OkHttp.string(request1).map(new Func1<String, List<EpisodeEntity>>() {
                                    @Override
                                    public List<EpisodeEntity> call(String s) {
                                        return DocumentUtils.getEpisodes(Jsoup.parse(s));
                                    }
                                });
                            }
                        }).toList().map(new Func1<List<List<EpisodeEntity>>, List<EpisodeEntity>>() {
                            @Override
                            public List<EpisodeEntity> call(List<List<EpisodeEntity>> lists) {
                                Log.i("Tag", "tolist");
                                for (List<EpisodeEntity> episodeEntities : lists) {
                                    episodeEntities0.addAll(episodeEntities);
                                }
                                return episodeEntities0;
                            }
                        });
            }
        });
    }

    @Override
    public Observable<List<PodcastEntity>> getPodcasts(final int page) {
        final String url = BASE_URL + "/podcasts?page=" + page;
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.string(request).map(new Func1<String, PageEntity>() {

            @Override
            public PageEntity call(String s) {
                return DocumentUtils.getPage(Jsoup.parse(s), false);
            }
        }).map(new Func1<PageEntity, List<PodcastEntity>>() {
            @Override
            public List<PodcastEntity> call(PageEntity pageEntity) {
                return pageEntity.getPodcasts();
            }
        });
    }

    @Override
    public Observable<List<PodcastEntity>> getPodcasts() {
        return null;
    }

    @Override
    public Observable<PodcastEntity> getPodcast(String id) {
        final String url = BASE_URL + "/programmes/" + id + "/episodes/downloads.rss";

        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.inputStream(request).map(new Func1<InputStream, ItunesChannel>() {
            @Override
            public ItunesChannel call(InputStream inputStream) {
                return ItunesChannelRssReader.getInstance().load(inputStream);
            }
        }).map(new Func1<ItunesChannel, PodcastEntity>() {
            @Override
            public PodcastEntity call(ItunesChannel itunesChannel) {
                PodcastEntity podcastEntity = new PodcastEntity();
                podcastEntity.setName(itunesChannel.getTitle());
                podcastEntity.setArtwork(itunesChannel.getImage().getUrl());
                podcastEntity.setLastUpdate(itunesChannel.getLastBuildDate());
                podcastEntity.setDaysLive(itunesChannel.getPpgSeriesDetails().getDaysLive());
                podcastEntity.setFrequency(itunesChannel.getPpgSeriesDetails().getFrequency());
                List<EpisodeEntity> episodes = new ArrayList<>();
                for (ItunesItem itunesItem : itunesChannel.getItunesItems()) {
                    EpisodeEntity episode = new EpisodeEntity();
                    episode.setId(itunesItem.getPpgCanonical().substring("/programmes/".length()));
                    episode.setTitle(itunesItem.getTitle());
                    episode.setDescription(itunesItem.getDescription());
                    episode.setDuration(itunesItem.getItunesDuration());
                    episode.setPubDate(itunesItem.getPubDate());
                    episode.setLink(itunesItem.getLink());
                    episode.setArtwork(podcastEntity.getArtwork());
                    episodes.add(episode);
                }
                podcastEntity.setEpisodes(episodes);
                return podcastEntity;
            }
        }).zipWith(getEpisodes(id), new Func2<PodcastEntity, List<EpisodeEntity>, PodcastEntity>() {
            @Override
            public PodcastEntity call(PodcastEntity podcastEntity, List<EpisodeEntity> episodeEntities1) {
                List<EpisodeEntity> episodeEntities0 = podcastEntity.getEpisodes();
                for (int i = 0; i < episodeEntities0.size(); i++) {
                    EpisodeEntity episodeEntity0 = episodeEntities0.get(i);
                    if (i < episodeEntities1.size()) {
                        EpisodeEntity episodeEntity1 = episodeEntities1.get(i);
                        if (episodeEntity0.getId().equals(episodeEntity1.getId())) {
                            episodeEntity0.setArtwork(episodeEntity1.getArtwork());
                        }
                    }
                }
                return podcastEntity;
            }
        });
    }

    @Override
    public Observable<List<PodcastEntity>> search(String text) {
        final String url = BASE_URL + "/podcasts/search.json?q=" + text;
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.string(request).map(new Func1<String, List<PodcastEntity>>() {
            @Override
            public List<PodcastEntity> call(String s) {
                List<PodcastEntity> podcastEntities = new ArrayList<>();
                JSONArray array = null;
                try {
                    array = new JSONArray(s);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject object = array.optJSONObject(i);
                        PodcastEntity podcastEntity = new PodcastEntity();
                        podcastEntity.setId(object.optString("pid"));
                        podcastEntity.setName(object.optString("title"));
                        podcastEntity.setHref(object.optString("link"));
                        podcastEntity.setArtwork(object.optString("image"));
                        podcastEntity.setDescription(object.optString("description"));
                        podcastEntities.add(podcastEntity);
                    }
                } catch (JSONException e) {
                    throw Exceptions.propagate(e);
                }

                return podcastEntities;
            }
        });
    }

    @Override
    public Observable<CategoryEntity> getCategory(final String categoryId) {
        final String url = BASE_URL + "/podcasts/genre/" + categoryId;
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.string(request).map(new Func1<String, PageEntity>() {

            @Override
            public PageEntity call(String s) {
                return DocumentUtils.getPage(Jsoup.parse(s), false);
            }
        }).map(new Func1<PageEntity, List<PodcastEntity>>() {
            @Override
            public List<PodcastEntity> call(PageEntity pageEntity) {
                return pageEntity.getPodcasts();
            }
        }).map(new Func1<List<PodcastEntity>, CategoryEntity>() {
            @Override
            public CategoryEntity call(List<PodcastEntity> podcastEntities) {
                CategoryEntity categoryEntity = new CategoryEntity();
                categoryEntity.setId(categoryId);
                categoryEntity.setName(categoryId);
                categoryEntity.setPodcastEntities(podcastEntities);
                return categoryEntity;
            }
        });
    }

    @Override
    public Observable<List<CategoryEntity>> getCategories() {
        final String url = "https://raw.githubusercontent.com/Aspsine/Podcast/dev/data/src/main/assets/categories.json";
        final Request request = new Request.Builder().url(url).get().build();

        return OkHttp.string(request).map(new Func1<String, List<CategoryEntity>>() {
            @Override
            public List<CategoryEntity> call(String s) {
                List<CategoryEntity> categoryEntities = new ArrayList<>();
                try {
                    JSONObject json = new JSONObject(s);
                    JSONArray jsonArray = json.optJSONArray("Categories");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        CategoryEntity categoryEntity = new CategoryEntity();
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        categoryEntity.setName(jsonObject.optString("name"));
                        String href = jsonObject.optString("href");
                        categoryEntity.setHref(href);
                        categoryEntity.setId(href.substring("/podcasts/genre/".length()));
                        categoryEntities.add(categoryEntity);
                    }
                } catch (JSONException e) {
                    throw Exceptions.propagate(e);
                }
                return categoryEntities;
            }
        });
    }

    @Override
    public Observable<StationEntity> getStation(String id) {
        return null;
    }

    @Override
    public Observable<List<StationEntity>> getStations() {
        final String url = "https://raw.githubusercontent.com/Aspsine/Podcast/dev/data/src/main/assets/stations.json";
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.string(request).map(new Func1<String, List<StationEntity>>() {
            List<StationEntity> stationEntities = new ArrayList<>();

            @Override
            public List<StationEntity> call(String s) {
                try {
                    JSONArray jsonArray = new JSONArray(s);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        StationEntity stationEntity = new StationEntity();
                        stationEntity.setName(jsonObject.optString("name"));
                        String href = jsonObject.optString("href");
                        stationEntity.setHref(href);
                        stationEntity.setId(href.substring("/podcasts/".length()));
                        stationEntities.add(stationEntity);
                    }
                } catch (JSONException e) {
                    Exceptions.propagate(e);
                }
                return stationEntities;
            }
        });
    }
}
