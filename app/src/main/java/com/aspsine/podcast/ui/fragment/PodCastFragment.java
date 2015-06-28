package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.PodCast;
import com.aspsine.podcast.network.CacheInterceptor;
import com.aspsine.podcast.network.OkHttp;
import com.aspsine.podcast.network.OkHttpRssReader;
import com.aspsine.podcast.util.L;
import com.aspsine.rss.model.itunes.ItunesChannel;
import com.aspsine.rss.parser.RSSParser;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;


import java.io.IOException;
import java.io.InputStream;

/**
 * A simple {@link Fragment} subclass.
 */
public class PodCastFragment extends Fragment {
    private PodCast mPodCast;

    public static PodCastFragment newInstance(PodCast podCast) {
        PodCastFragment podCastFragment = new PodCastFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("EXTRA_PODCAST", podCast);
        podCastFragment.setArguments(bundle);
        return podCastFragment;
    }

    public PodCastFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPodCast = (PodCast) getArguments().getSerializable("EXTRA_PODCAST");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pod_cast, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refresh();
    }

    private void refresh() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Request request = new Request.Builder().url("http://www.bbc.co.uk" + mPodCast.getHref()).build();
                try {
                    Response response = OkHttp.createHttpClient().newCall(request).execute();
                    if (response.isSuccessful()) {
                        String redirectUrl = response.priorResponse().header("Location");
                        String rssUrl = redirectUrl + ".rss";
                        L.i("rss = " + rssUrl);
                        Response resp = OkHttp.createHttpClient().newCall(new Request.Builder().url(rssUrl).build()).execute();
                        if (resp.isSuccessful()) {
                            InputStream inputStream = resp.body().byteStream();
                            ItunesChannel channel = OkHttpRssReader.getInstance().load(inputStream);
                            L.i(channel.toString());
                            return;
                        }
                    }
                    L.i("rss", "error");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
