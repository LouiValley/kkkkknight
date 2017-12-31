package info.smartkit.shiny.guide.domain.vo;

import javax.persistence.*;

@Entity
public class Train {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    //User part
    @Column(name = "msno") //must same excel header (first row)
    private String msno;

    //User part
    @Column(name = "song_id") //must same excel header (first row)
    private String song_id;

    @Column(name = "source_system_tab") //must same excel header (first row)0,1,2....
    private String source_system_tab;

    @Column(name = "source_screen_name") //must same excel header (first row)0,1,2....
    private String source_screen_name;

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                ", msno='" + msno + '\'' +
                ", song_id='" + song_id + '\'' +
                ", source_system_tab='" + source_system_tab + '\'' +
                ", source_screen_name='" + source_screen_name + '\'' +
                ", source_type='" + source_type + '\'' +
                ", target=" + target +
                '}';
    }

    public Train() {
    }

    @Column(name = "source_type") //must same excel header (first row)0,1,2....
    private String source_type;

    public Train(String msno, String song_id, String source_system_tab, String source_screen_name, String source_type, int target) {
        this.msno = msno;
        this.song_id = song_id;
        this.source_system_tab = source_system_tab;
        this.source_screen_name = source_screen_name;
        this.source_type = source_type;
        this.target = target;
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

    public String getSource_system_tab() {
        return source_system_tab;
    }

    public void setSource_system_tab(String source_system_tab) {
        this.source_system_tab = source_system_tab;
    }

    public String getSource_screen_name() {
        return source_screen_name;
    }

    public void setSource_screen_name(String source_screen_name) {
        this.source_screen_name = source_screen_name;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    @Column(name = "target") //must same excel header (first row)0,1,2....
    private int target;
}
