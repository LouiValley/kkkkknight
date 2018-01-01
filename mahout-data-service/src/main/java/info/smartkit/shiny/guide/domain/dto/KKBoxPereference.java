package info.smartkit.shiny.guide.domain.dto;

/**
 *@see:https://blogdotrichanchordotcom.wordpress.com/2015/11/12/user-based-collaborative-filtering-with-apache-mahout/
 *
 */
public class KKBoxPereference {

    public KKBoxPereference(long userId, long itemId, float rating) {
        this.userId = userId;
        this.itemId = itemId;
        this.rating = rating;
    }

    public KKBoxPereference() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    private long userId;
    private long itemId;
    private double rating;

    @Override
    public String toString() {
        return "KKBoxPereference{" +
                "userId=" + userId +
                ", itemId=" + itemId +
                ", rating=" + rating +
                '}';
    }
}
