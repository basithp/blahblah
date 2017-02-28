package co.bazi.reactsun.Adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import co.bazi.reactsun.Model.FeedItem;
import co.bazi.reactsun.R;

/**
 * Created by mrajamani on 22/02/17.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<FeedItem> feedItemList;

    public RecyclerAdapter(List<FeedItem> feedItemList) {
        this.feedItemList = feedItemList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                View heroView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_layout,parent,false);
                return new HeroViewHolder(heroView);
            case 1:
                View villianView = LayoutInflater.from(parent.getContext()).inflate(R.layout.villian_layout,parent,false);
                return new VillainViewHolder(villianView);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedItem feedItem = feedItemList.get(position);
        switch (holder.getItemViewType()){
            case  0:
                HeroViewHolder heroViewHolder = (HeroViewHolder) holder;
                if(feedItem.getSlug() == null) {
                    heroViewHolder.heroSlugTextView.setVisibility(View.GONE);
                } else {
                    heroViewHolder.heroSlugTextView.setText(feedItem.getSlug());
                    heroViewHolder.heroCaptionTextView.setVisibility(View.VISIBLE);
                }
                Glide.with(heroViewHolder.heroImageView.getContext())
                        .load(feedItem.getImageURL())
                        .centerCrop()
                        .into(heroViewHolder.heroImageView);
                heroViewHolder.heroCaptionTextView.setText(feedItem.getTitle());
                break;
            case 1:
                VillainViewHolder villainViewHolder = (VillainViewHolder) holder;
                if (feedItem.getSlug()== null){
                    villainViewHolder.villianSlugTextView.setVisibility(View.GONE);
                }else{
                    villainViewHolder.villianSlugTextView.setText(feedItem.getSlug());
                    villainViewHolder.villianSlugTextView.setVisibility(View.VISIBLE);
                }
                Glide.with(villainViewHolder.villianImageView.getContext())
                        .load(feedItem.getImageURL())
                        .centerCrop()
                        .into(villainViewHolder.villianImageView);
                villainViewHolder.villianHeadingTextView.setText(feedItem.getTitle());
                villainViewHolder.villianSummaryTextView.setText(feedItem.getSummary());
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        FeedItem feedItem = feedItemList.get(position);
        return feedItem.getItemType();
    }

    @Override
    public int getItemCount() {
        return feedItemList.size();
    }

    public class HeroViewHolder extends RecyclerView.ViewHolder{

        private TextView heroSlugTextView;
        private ImageView heroImageView;
        private TextView heroCaptionTextView;

        public HeroViewHolder(View itemView) {
            super(itemView);
            heroSlugTextView = (TextView) itemView.findViewById(R.id.hero_slug);
            heroImageView = (ImageView) itemView.findViewById(R.id.hero_image);
            heroCaptionTextView = (TextView) itemView.findViewById(R.id.hero_caption);
        }

    }
    public class VillainViewHolder extends RecyclerView.ViewHolder{

        private TextView villianSlugTextView;
        private ImageView villianImageView;
        private TextView villianHeadingTextView;
        private TextView villianSummaryTextView;
        public VillainViewHolder(View itemView) {
            super(itemView);
            villianSlugTextView = (TextView) itemView.findViewById(R.id.villian_slug);
            villianImageView = (ImageView) itemView.findViewById(R.id.villian_image);
            villianHeadingTextView = (TextView) itemView.findViewById(R.id.villian_heading);
            villianSummaryTextView = (TextView) itemView.findViewById(R.id.villian_summary);
        }

    }
}
