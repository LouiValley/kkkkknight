package info.smartkit.shiny.guide.domain.vo;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //User part
    @Column(name = "song_id") //must same excel header (first row)
    private String song_id;

    @Column(name = "song_length") //must same excel header (first row)0,1,2....
    private int song_length;

    @Column(name = "genre_ids") //must same excel header (first row)0,1,2....
    private int genre_ids;


    @Column(name = "artist_name") //must same excel header (first row)0,1,2....
    private String artist_name;

    @Column(name = "composer") //must same excel header (first row)0,1,2....
    private String composer;

    @Column(name = "lyricist") //must same excel header (first row)0,1,2....
    private String lyricist;

    @Column(name = "language") //must same excel header (first row)0,1,2....
    private String language;
}
