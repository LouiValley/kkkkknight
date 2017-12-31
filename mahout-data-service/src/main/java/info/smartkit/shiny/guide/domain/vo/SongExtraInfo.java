package info.smartkit.shiny.guide.domain.vo;

import javax.persistence.*;

@Entity
public class SongExtraInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsrc() {
        return isrc;
    }

    public SongExtraInfo() {
    }

    @Override
    public String toString() {
        return "SongExtraInfo{" +
                "id=" + id +
                ", song_id='" + song_id + '\'' +
                ", name='" + name + '\'' +
                ", isrc='" + isrc + '\'' +
                '}';
    }

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    public SongExtraInfo(String song_id, String name, String isrc) {
        this.song_id = song_id;
        this.name = name;
        this.isrc = isrc;
    }

    //User part
    @Column(name = "song_id") //must same excel header (first row)
    private String song_id;

    @Column(name = "name") //must same excel header (first row)0,1,2....
    private String name;

    @Column(name = "isrc") //must same excel header (first row)0,1,2....
    private String isrc;
}
