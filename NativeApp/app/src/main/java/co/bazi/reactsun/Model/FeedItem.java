package co.bazi.reactsun.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mbasith on 09/02/17.
 */

public class FeedItem {
    public int getHERO() {
        return HERO;
    }

    public void setHERO(int HERO) {
        this.HERO = HERO;
    }

    public int getVILLAIN() {
        return VILLAIN;
    }

    public void setVILLAIN(int VILLAIN) {
        this.VILLAIN = VILLAIN;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    int HERO=0,VILLAIN=1;
    @SerializedName("type")
    String type;

    @SerializedName("slug")
    String slug;

    @SerializedName("image")
    String imageURL;

    @SerializedName("title")
    String title;

    @SerializedName("summary")
    String summary;

    @Override
    public String toString() {
        return String.format("{\n" +
                "type : %s\n" +
                "slug : %s\n" +
                "image : %s\n" +
                "title : %s\n" +
                "summary : %s\n" +
                "},\n",this.type,this.slug,this.imageURL,this.title,this.summary);
    }

    public int getItemType(){
        return this.type.equals("Hero") ? HERO : VILLAIN;
    }
}
