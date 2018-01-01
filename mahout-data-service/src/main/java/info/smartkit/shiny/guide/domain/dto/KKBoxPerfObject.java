package info.smartkit.shiny.guide.domain.dto;

/**
*@see:https://blogdotrichanchordotcom.wordpress.com/2015/11/12/user-based-collaborative-filtering-with-apache-mahout/
*
*/
public class KKBoxPerfObject {

    private String msno;
    private String song_id;

    public KKBoxPerfObject(String msno, String song_id, int target) {
        this.msno = msno;
        this.song_id = song_id;
        this.target = target;
    }

    public KKBoxPerfObject() {
    }

    public String getMsno() {
        return msno;
    }

    public void setMsno(String msno) {
        this.msno = msno;
    }

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    private int target;

    @Override
    public String toString() {
        return "KKBoxPerfObject{" +
                "msno='" + msno + '\'' +
                ", song_id='" + song_id + '\'' +
                ", target=" + target +
                '}';
    }
}
