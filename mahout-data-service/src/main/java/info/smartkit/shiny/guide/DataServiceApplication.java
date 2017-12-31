package info.smartkit.shiny.guide;

import com.blogspot.na5cent.exom.ExOM;
import info.smartkit.shiny.guide.domain.vo.Member;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.List;

@SpringBootApplication
public class DataServiceApplication {

	private static Logger LOG = LogManager.getLogger(DataServiceApplication.class);

	public static void main(String[] args) throws Throwable {

		SpringApplication.run(DataServiceApplication.class, args);

		Class mainClass = DataServiceApplication.class.getClass();
		//initial CSV readers.
		File excelFile_member = new File(mainClass.getResource("KKBOX/members.csv").getPath());
		List<Member> excelFile_members= ExOM.mapFromExcel(excelFile_member)
                    .toObjectOf(Member.class)
                    .map();

		for (Member item : excelFile_members) {
			LOG.debug("Member --> {}"+item.toString());
		}

		//initial CSV readers.
		File excelFile_song = new File(mainClass.getResource("KKBOX/songs.csv").getPath());
		List<Member> excelFile_songs = ExOM.mapFromExcel(excelFile_song)
				.toObjectOf(Member.class)
				.map();

		for (Member item : excelFile_songs) {
			LOG.debug("Song --> {}"+item.toString());
		}

		//initial CSV readers.
		File excelFile_song_extra_info = new File(mainClass.getResource("KKBOX/song_extra_info.csv").getPath());
		List<Member> excelFile_song_extra_infos = ExOM.mapFromExcel(excelFile_song_extra_info)
				.toObjectOf(Member.class)
				.map();

		for (Member item : excelFile_song_extra_infos) {
			LOG.debug("SongExtraInfo --> {}"+item.toString());
		}

		//initial CSV readers.
		File excelFile_train = new File(mainClass.getResource("/train.csv").getPath());
		List<Member> excelFile_trains = ExOM.mapFromExcel(excelFile_train)
				.toObjectOf(Member.class)
				.map();

		for (Member item : excelFile_trains) {
			LOG.debug("Train --> {}"+item.toString());
		}

	}
}
