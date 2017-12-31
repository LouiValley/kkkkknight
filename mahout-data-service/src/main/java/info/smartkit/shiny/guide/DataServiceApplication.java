package info.smartkit.shiny.guide;

import com.blogspot.na5cent.exom.ExOM;
import info.smartkit.shiny.guide.domain.vo.Member;
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
		File excelFile_song = new File(mainClass.getResource("KKBOX/songs.xlsx").getPath());
		List<Member> excelFile_songs = ExOM.mapFromExcel(excelFile_song)
				.toObjectOf(Member.class)
				.map();

		for (Member item : excelFile_songs) {
			LOG.info("Song --> {}"+item.toString());
		}

		//initial CSV readers.
		File excelFile_song_extra_info = new File(mainClass.getResource("KKBOX/song_extra_info.xlsx").getPath());
		List<Member> excelFile_song_extra_infos = ExOM.mapFromExcel(excelFile_song_extra_info)
				.toObjectOf(Member.class)
				.map();

		for (Member item : excelFile_song_extra_infos) {
			LOG.info("SongExtraInfo --> {}"+item.toString());
		}

		//initial CSV readers.
		File excelFile_train = new File(mainClass.getResource("KKBOX/train.xlsx").getPath());
		List<Member> excelFile_trains = ExOM.mapFromExcel(excelFile_train)
				.toObjectOf(Member.class)
				.map();

		for (Member item : excelFile_trains) {
			LOG.info("Train --> {}"+item.toString());
		}

	}
}
