package com.aspsine.podcast.ui.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Page;
import com.aspsine.podcast.model.Station;
import com.aspsine.podcast.network.OkHttp;
import com.aspsine.podcast.ui.adapter.PodCastAdapter;
import com.aspsine.podcast.ui.widget.LoadMoreRecyclerView;
import com.aspsine.podcast.util.DocumentUtils;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * A simple {@link Fragment} subclass.
 */
public class StationFragment extends Fragment implements LoadMoreRecyclerView.onLoadMoreListener {

    ProgressBar progressBar;
    LoadMoreRecyclerView recyclerView;

    private Station mStation;
    private PodCastAdapter mAdapter;

    private int mPageIndex;

    private int mPageSize;

    public static StationFragment newInstance(Station station) {
        StationFragment stationFragment = new StationFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("EXTRA_STATION", station);
        stationFragment.setArguments(bundle);
        return stationFragment;
    }

    public StationFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStation = (Station) getArguments().getSerializable("EXTRA_STATION");
        mAdapter = new PodCastAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_station, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        recyclerView = (LoadMoreRecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setOnLoadMoreListener(this);
        Toast.makeText(getActivity(), mStation.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refresh();
    }

    private void refresh() {
        progressBar.setVisibility(View.VISIBLE);
        new Thread(new GetPageTask(mStation.getHref(), 1, handler)).start();
    }

    private void loadMore() {
        if (mPageIndex < mPageSize) {
            recyclerView.setLoadingMore(true);
            mPageIndex++;
            new Thread(new GetPageTask(mStation.getHref(), mPageIndex, handler)).start();
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            recyclerView.setLoadingMore(false);
            progressBar.setVisibility(View.GONE);
            if (msg.what == 0) {
                Page page = (Page) msg.obj;
                if (page.isParsePageInfo()){
                    mPageSize = page.getPodCastNum() / page.getPageSize() + (page.getPodCastNum() % page.getPageSize() == 0 ? 0 : 1);
                    mAdapter.setData(page.getPodCasts());
                }else {
                    mAdapter.appendData(page.getPodCasts());
                }
            } else {
                mPageIndex--;
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    public void onLoadMore() {
        loadMore();
    }

    private static class GetPageTask implements Runnable {
        private String mHref;
        private int mPageIndex;
        private Handler mHandler;

        public GetPageTask(String href, int pageIndex, Handler handler) {
            this.mPageIndex = pageIndex;
            this.mHref = href;
            this.mHandler = handler;
        }

        @Override
        public void run() {
            try {
                Request request = new Request.Builder().url("http://www.bbc.co.uk" + mHref + "?page=" + mPageIndex).build();
                Response response = OkHttp.createHttpClient().newCall(request).execute();
                String html = response.body().string();
                Log.i("html", html);
                Document document = Jsoup.parse(html);
                Page page = DocumentUtils.getPage(document, mPageIndex == 1);
                mHandler.obtainMessage(0, page).sendToTarget();
            } catch (Exception e) {
                mHandler.obtainMessage(-1).sendToTarget();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }


}
