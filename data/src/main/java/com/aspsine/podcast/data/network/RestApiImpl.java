package com.aspsine.podcast.data.network;

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

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Func1;

/**
 * Created by zhangfan10 on 16/10/9.
 */

public class RestApiImpl implements RestApi {

    private static final String BASE_URL = "http://www.bbc.co.uk";

    @Override
    public Observable<List<PodcastEntity>> getPodcasts(final int page) {
        final String url = BASE_URL + "/podcasts?page=" + page;
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.execute(request)
                .map(new Func1<Response, String>() {
                    @Override
                    public String call(Response response) {
                        try {
                            return response.body().string();
                        } catch (IOException e) {
                            throw new OnErrorFailedException(e);
                        }
                    }
                }).map(new Func1<String, PageEntity>() {

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
        return OkHttp.execute(request).map(new Func1<Response, InputStream>() {
            @Override
            public InputStream call(Response response) {
                return response.body().byteStream();
            }
        }).map(new Func1<InputStream, ItunesChannel>() {
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
                List<EpisodeEntity> episodes = new ArrayList<>();
                for (ItunesItem itunesItem : itunesChannel.getItunesItems()) {
                    EpisodeEntity episode = new EpisodeEntity();
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
        });
    }

    @Override
    public Observable<List<PodcastEntity>> search(String text) {
        final String url = BASE_URL + "/podcasts/search.json?q=" + text;
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.execute(request).map(new Func1<Response, String>() {
            @Override
            public String call(Response response) {
                try {
                    return response.body().string();
                } catch (IOException e) {
                    throw new OnErrorFailedException(e);
                }
            }
        }).map(new Func1<String, List<PodcastEntity>>() {
            @Override
            public List<PodcastEntity> call(String s) {
                List<PodcastEntity> podcastEntities = new ArrayList<>();
                JSONArray array = null;
                try {
                    array = new JSONArray(s);
                } catch (JSONException e) {
                    throw new OnErrorFailedException(e);
                }
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
                return podcastEntities;
            }
        });
    }

    @Override
    public Observable<CategoryEntity> getCategory(final String categoryId) {
        final String url = BASE_URL + "podcasts/genre/" + categoryId;
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.execute(request)
                .map(new Func1<Response, String>() {
                    @Override
                    public String call(Response response) {
                        try {
                            return response.body().string();
                        } catch (IOException e) {
                            throw new OnErrorFailedException(e);
                        }
                    }
                }).map(new Func1<String, PageEntity>() {

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

        return null;
    }

    @Override
    public Observable<StationEntity> getStation(String id) {
        return null;
    }

    @Override
    public Observable<List<StationEntity>> getStations() {
        final String url = BASE_URL + "/podcasts";
        final Request request = new Request.Builder().url(url).get().build();
        return OkHttp.execute(request)
                .map(new Func1<Response, String>() {
                    @Override
                    public String call(Response response) {
                        try {
                            return response.body().string();
                        } catch (IOException e) {
                            throw new OnErrorFailedException(e);
                        }
                    }
                }).map(new Func1<String, List<StationEntity>>() {
                    @Override
                    public List<StationEntity> call(String s) {
                        return DocumentUtils.getStations(Jsoup.parse(s));
                    }
                });
    }
}
