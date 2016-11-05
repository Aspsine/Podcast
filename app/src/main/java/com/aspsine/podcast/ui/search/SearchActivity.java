package com.aspsine.podcast.ui.search;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.aspsine.podcast.R;
import com.aspsine.podcast.data.entity.mapper.PodcastDataMapper;
import com.aspsine.podcast.data.repository.SearchDataRespository;
import com.aspsine.podcast.data.source.search.SearchDataSourceFactory;
import com.aspsine.podcast.domain.Podcast;
import com.aspsine.podcast.domain.interactor.GetSearchResult;
import com.aspsine.podcast.domain.repository.SearchRepository;
import com.aspsine.podcast.ui.base.BaseActivity;
import com.aspsine.podcast.ui.search.item.SearchPodcastViewHolderFactory;
import com.aspsine.podcast.ui.search.item.SearchPodcastViewModel;
import com.aspsine.podcast.ui.search.mapper.SearchPodcastViewModelMapper;
import com.aspsine.podcast.widget.recyclerView.item.ItemViewAdapter;
import com.aspsine.podcast.widget.recyclerView.item.MultiTypeManager;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SearchActivity extends BaseActivity {

    private EditText editText;

    private RecyclerView recyclerView;

    private ItemViewAdapter<SearchPodcastViewModel> mAdapter;

    private GetSearchResult mGetSearchResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText = (EditText) findViewById(R.id.edit_text);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MultiTypeManager multiTypeManager = new MultiTypeManager();
        multiTypeManager.register(SearchPodcastViewModel.class, new SearchPodcastViewHolderFactory());
        mAdapter = new ItemViewAdapter<>(multiTypeManager);
        recyclerView.setAdapter(mAdapter);

        SearchRepository searchRepository = new SearchDataRespository(new SearchDataSourceFactory(), new PodcastDataMapper());

        mGetSearchResult = new GetSearchResult(searchRepository, Schedulers.io(), AndroidSchedulers.mainThread());

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mGetSearchResult.setKeyword(s.toString()).execute(new Subscriber<List<Podcast>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Podcast> podcasts) {
                        mAdapter.setList(new SearchPodcastViewModelMapper().transform(podcasts));
                    }
                });
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
