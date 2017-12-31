package info.smartkit.shiny.guide.domain.dto;

public class SongFullInfo {

    public SongFullInfo(String song_id, String song_length, String genre_ids, String artist_name, String composer, String lyricist, String language, String name, String isrc) {
        this.song_id = song_id;
        this.song_length = song_length;
        this.genre_ids = genre_ids;
        this.artist_name = artist_name;
        this.composer = composer;
        this.lyricist = lyricist;
        this.language = language;
        this.name = name;
        this.isrc = isrc;
    }

    public SongFullInfo() {
    }

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

    public void setLanguage(String language) {
        this.language = language;
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

    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    private String song_id;

    private String song_length;

    private String genre_ids;

    private String artist_name;

    private String composer;

    private String lyricist;

    private String language;

    private String name;

    private String isrc;

    @Override
    public String toString() {
        return "SongFullInfo{" +
                "song_id='" + song_id + '\'' +
                ", song_length='" + song_length + '\'' +
                ", genre_ids='" + genre_ids + '\'' +
                ", artist_name='" + artist_name + '\'' +
                ", composer='" + composer + '\'' +
                ", lyricist='" + lyricist + '\'' +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", isrc='" + isrc + '\'' +
                '}';
    }
}
