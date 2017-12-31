package info.smartkit.shiny.guide;

import com.blogspot.na5cent.exom.ExOM;
import info.smartkit.shiny.guide.domain.vo.Member;
import info.smartkit.shiny.guide.domain.vo.Song;
import info.smartkit.shiny.guide.domain.vo.SongExtraInfo;
import info.smartkit.shiny.guide.domain.vo.Train;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.net.URL;
import java.util.List;

@SpringBootApplication
public class DataServiceApplication {

	private static Logger LOG = LogManager.getLogger(DataServiceApplication.class);

	public static void main(String[] args) throws Throwable {

		SpringApplication.run(DataServiceApplication.class, args);

		Class mainClass = DataServiceApplication.class.getClass();
		//initial CSV readers.
		URL url_members = mainClass.getResource("/KKBOX/members.xlsx");
		File excelFile_member = new File(url_members.getPath());
		List<Member> excelFile_members= ExOM.mapFromExcel(excelFile_member)
                    .toObjectOf(Member.class)
                    .map();

		for (Member item : excelFile_members) {
			LOG.info("Member --> {}"+item.toString());
		}

		//initial CSV readers.
		URL url_songs = mainClass.getResource("/KKBOX/songs.xlsx");
		File excelFile_song = new File(url_songs.getPath());
		List<Song> excelFile_songs = ExOM.mapFromExcel(excelFile_song)
				.toObjectOf(Song.class)
				.map();

		for (Song item : excelFile_songs) {
			LOG.info("Song --> {}"+item.toString());
		}

		//initial CSV readers.
		URL url_song_extra_info = mainClass.getResource("/KKBOX/song_extra_info.xlsx");
		File excelFile_song_extra_info = new File(url_song_extra_info.getPath());
		List<SongExtraInfo> excelFile_song_extra_infos = ExOM.mapFromExcel(excelFile_song_extra_info)
				.toObjectOf(SongExtraInfo.class)
				.map();

		for (SongExtraInfo item : excelFile_song_extra_infos) {
			LOG.info("SongExtraInfo --> {}"+item.toString());
		}

		//initial CSV readers.
		URL url_train = mainClass.getResource("/KKBOX/train.xlsx");
		File excelFile_train = new File(url_train.getPath());
		List<Train> excelFile_trains = ExOM.mapFromExcel(excelFile_train)
				.toObjectOf(Train.class)
				.map();

		for (Train item : excelFile_trains) {
			LOG.info("Train --> {}"+item.toString());
		}

	}
}
