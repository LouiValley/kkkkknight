package info.smartkit.shiny.guide.domain.vo;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public String getSong_id() {
        return song_id;
    }

    public void setSong_id(String song_id) {
        this.song_id = song_id;
    }

    public String getSong_length() {
        return song_length;
    }

    public void setSong_length(String song_length) {
        this.song_length = song_length;
    }

    public String getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(String genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getComposer() {
        return composer;
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getLyricist() {
        return lyricist;
    }

    public void setLyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getLanguage() {
        return language;
    }

    public Song() {
    }

    public Song(String song_id, String song_length, String genre_ids, String artist_name, String composer, String lyricist, String language) {

        this.song_id = song_id;
        this.song_length = song_length;
        this.genre_ids = genre_ids;
        this.artist_name = artist_name;
        this.composer = composer;
        this.lyricist = lyricist;
        this.language = language;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", song_id='" + song_id + '\'' +
                ", song_length=" + song_length +
                ", genre_ids=" + genre_ids +
                ", artist_name='" + artist_name + '\'' +
                ", composer='" + composer + '\'' +
                ", lyricist='" + lyricist + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    //User part
    @Column(name = "song_id") //must same excel header (first row)
    private String song_id;

    @Column(name = "song_length") //must same excel header (first row)0,1,2....
    private String song_length;

    @Column(name = "genre_ids") //must same excel header (first row)0,1,2....
    private String genre_ids;


    @Column(name = "artist_name") //must same excel header (first row)0,1,2....
    private String artist_name;

    @Column(name = "composer") //must same excel header (first row)0,1,2....
    private String composer;

    @Column(name = "lyricist") //must same excel header (first row)0,1,2....
    private String lyricist;

    @Column(name = "language") //must same excel header (first row)0,1,2....
    private String language;
}
