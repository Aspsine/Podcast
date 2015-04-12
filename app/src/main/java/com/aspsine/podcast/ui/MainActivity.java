package com.aspsine.podcast.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.aspsine.podcast.R;
import com.aspsine.podcast.model.Album;
import com.aspsine.podcast.model.Page;
import com.aspsine.podcast.model.Station;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    TextView tvLog;
    Button btnConnect;
    ProgressDialog progressDialog;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLog = (TextView) findViewById(R.id.log);
        btnConnect = (Button) findViewById(R.id.connect);
        listView = (ListView) findViewById(R.id.listview);
        btnConnect.setOnClickListener(this);
        progressDialog = new ProgressDialog(this);

        tvLog.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onClick(View v) {
        connect();
    }

    private void connect() {
        progressDialog.show();
        new Thread(new MyRunnable()).start();
    }

    private class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Document document = Jsoup.connect("http://www.bbc.co.uk" + "/podcasts/radio4").get();
//                Element divPcFilter = document.getElementById("pc-filter");
//
//                List<Station> stations = getStations("pc-filter-networks", divPcFilter);
//                List<Station> genres = getStations("pc-filter-genres", divPcFilter);
//
//                Sections sections = new Sections(stations, genres);

//                List<Album> albums = getAlbums(document);


                Element liPage = document.select(".nav-pages-showing").first();
                Elements spans = liPage.getElementsByTag("span");
                Page page = new Page();
                page.setPageIndex(Integer.valueOf(spans.get(0).text()));
                page.setPageSize(Integer.valueOf(spans.get(1).text()));

                handler.obtainMessage(0, page).sendToTarget();
            } catch (Exception e) {
                handler.obtainMessage(-1).sendToTarget();
                e.printStackTrace();
            }
        }
    }

    private List<Station> getStations(String id, Element element) {
        List<Station> list = new ArrayList<Station>();
        Element divGenres = element.getElementById(id);
        Elements elements = divGenres.getElementsByTag("ul");
        for (Element ul : elements) {
            Elements as = ul.getElementsByTag("a");
            for (Element a : as) {
                Station station = new Station();
                station.setHref(a.attr("href"));
                station.setName(a.text());
                list.add(station);
            }
        }
        return list;
    }

    private List<Album> getAlbums(Document document){
        List<Album> list = new ArrayList<Album>();
        Element ulAlbums = document.getElementById("results-list");
        Elements divsAlbums = ulAlbums.getElementsByClass("pc-results-box");
        for (Element divAlbum : divsAlbums){
            Album album = new Album();
            Element aArtWork = divAlbum.getElementsByClass("pc-results-artwork").get(0).getElementsByTag("a").get(0);
            album.setHref(aArtWork.attr("href"));
            album.setArtwork(aArtWork.getElementsByTag("img").get(0).text());
            String name = divAlbum.getElementsByClass("pc-result-heading").get(0).getElementsByTag("a").get(0).text();
            album.setName(name);
            String lastUpdate = divAlbum.getElementsByClass("pc-result-episode-date").get(0).text();
            album.setLastUpdate(lastUpdate);
            String averageDuration = divAlbum.getElementsByClass("pc-result-episode-duration").get(0).text();
            album.setAverageDuration(averageDuration);
            String description = divAlbum.getElementsByClass("pc-results-description").get(0).text();
            album.setDescription(description);
            list.add(album);
        }
        return list;
    }


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            progressDialog.dismiss();
            if (msg.what == 0) {
                Page page = (Page) msg.obj;
                tvLog.setText(page.getPageIndex() + " " + page.getPageSize());
//                Sections sections = (Sections) msg.obj;
//                List<Album> albums = (List<Album>) msg.obj;
//                listView.setAdapter(new ArrayAdapter<Album>(MainActivity.this, android.R.layout.test_list_item, albums));
            } else {
                Toast.makeText(MainActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
