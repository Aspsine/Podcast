package com.aspsine.podcast.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.widget.Toolbar;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Page;
import com.aspsine.podcast.model.PodCast;
import com.aspsine.podcast.model.Station;
import com.aspsine.podcast.network.OkHttp;
import com.aspsine.podcast.ui.activity.PodCastActivity;
import com.aspsine.podcast.ui.adapter.BaseRecyclerViewAdapter;
import com.aspsine.podcast.ui.adapter.PodCastAdapter;
import com.aspsine.podcast.ui.widget.DividerItemDecoration;
import com.aspsine.podcast.ui.widget.LoadMoreRecyclerView;
import com.aspsine.podcast.util.DocumentUtils;
import com.aspsine.podcast.util.L;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * A simple {@link Fragment} subclass.
 */
public class StationFragment extends Fragment implements LoadMoreRecyclerView.onLoadMoreListener, BaseRecyclerViewAdapter.OnItemClickListener<PodCast>, BaseRecyclerViewAdapter.OnItemMenuClickListener<PodCast> {

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
        mAdapter.setOnItemClickListener(this);
        mAdapter.setOnItemMenuClickListener(this);
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
//        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        recyclerView.setOnLoadMoreListener(this);
        Toast.makeText(getActivity(), mStation.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        refresh();
    }

    @Override
    public void onItemClick(View v, int position, PodCast podCast) {
        Intent intent = new Intent(getActivity(), PodCastActivity.class);
        intent.putExtra("EXTRA_PODCAST", podCast);
        getActivity().startActivity(intent);
    }

    @Override
    public void onItemMenuClick(final View v, int position, final PodCast podCast) {
        v.post(new Runnable() {
            @Override
            public void run() {
                showPopupMenu(v, podCast);
            }
        });
    }

    @Override
    public void onLoadMore() {
        loadMore();
    }

    private void showPopupMenu(View v, final PodCast podCast) {
        // Create a PopupMenu, giving it the clicked view for an anchor
        PopupMenu popup = new PopupMenu(getActivity(), v);

        // Inflate our menu resource into the PopupMenu's Menu
        popup.getMenuInflater().inflate(R.menu.menu_popup_podcast, popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_test:
                        Toast.makeText(getActivity(), "test" + podCast.getName(), Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
        popup.show();
    }

    private void refresh() {
        progressBar.setVisibility(View.VISIBLE);
        new Thread(new GetPageTask(mStation.getHref(), 1, handler)).start();
    }

    private void loadMore() {
        if (mPageIndex <= mPageSize) {
            recyclerView.setLoadingMore(true);
            new Thread(new GetPageTask(mStation.getHref(), mPageIndex, handler)).start();
        } else {
            Toast.makeText(getActivity(), "end", Toast.LENGTH_SHORT).show();
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
                if (page.isParsePageInfo()) {
                    mPageSize = page.getPodCastNum() / page.getPageSize() + (page.getPodCastNum() % page.getPageSize() == 0 ? 0 : 1);
                    mAdapter.setData(page.getPodCasts());
                } else {
                    mAdapter.appendData(page.getPodCasts());
                }
                mPageIndex++;
            } else {
                Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
            }
        }
    };


    private class GetPageTask implements Runnable {
        private String mHref;
        private int mPageIndex;

        public GetPageTask(String href, int pageIndex, Handler handler) {
            this.mPageIndex = pageIndex;
            this.mHref = href;
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
                handler.obtainMessage(0, page).sendToTarget();
            } catch (Exception e) {
                handler.obtainMessage(-1).sendToTarget();
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        L.i("onDestroyView");
        handler.removeCallbacksAndMessages(null);
    }


}
