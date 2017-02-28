package co.bazi.reactsun.APIHelper;

import java.util.ArrayList;
import java.util.List;

import co.bazi.reactsun.Activity.MainActivity;
import co.bazi.reactsun.Model.FeedItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by mbasith on 09/02/17.
 */

public class FeedProvider {

    public static void getFeedFromServer(final APIFeedFetcherCallback listener){

        APIInterface apiInterface = APIClient.getAPIClient().create(APIInterface.class);
        Call<List<FeedItem>> feedItemsCall = apiInterface.getFeeds();
        feedItemsCall.enqueue(new Callback<List<FeedItem>>() {
            @Override
            public void onResponse(Call<List<FeedItem>> call, Response<List<FeedItem>> response) {
                List<FeedItem> feedItemList = response.body();
                listener.OnFeedFetched(feedItemList);
            }

            @Override
            public void onFailure(Call<List<FeedItem>> call, Throwable t) {

            }
        });
    }


    public interface APIFeedFetcherCallback{
        public void OnFeedFetched(List<FeedItem> feedItemList);
    }
}
