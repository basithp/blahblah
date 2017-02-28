package co.bazi.reactsun.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

import co.bazi.reactsun.APIHelper.FeedProvider;
import co.bazi.reactsun.Adapter.RecyclerAdapter;
import co.bazi.reactsun.Model.FeedItem;
import co.bazi.reactsun.R;

public class MainActivity extends AppCompatActivity implements FeedProvider.APIFeedFetcherCallback{

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FeedProvider.getFeedFromServer(this);
    }

    @Override
    public void OnFeedFetched(List<FeedItem> feedItemList) {
        List<FeedItem> list = feedItemList;

        String feeds = "";
        for (FeedItem feedItem : list){
            feeds = feeds+feedItem.toString();
        }

        mAdapter = new RecyclerAdapter(feedItemList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
