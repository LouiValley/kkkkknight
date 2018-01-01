package info.smartkit.shiny.guide;

import com.blogspot.na5cent.exom.ExOM;
import info.smartkit.shiny.guide.domain.dao.MemberDao;
import info.smartkit.shiny.guide.domain.dao.SongDao;
import info.smartkit.shiny.guide.domain.dao.SongExtraInfoDao;
import info.smartkit.shiny.guide.domain.dao.TrainDao;
import info.smartkit.shiny.guide.domain.vo.Member;
import info.smartkit.shiny.guide.domain.vo.Song;
import info.smartkit.shiny.guide.domain.vo.SongExtraInfo;
import info.smartkit.shiny.guide.domain.vo.Train;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DataServiceApplication {

	private static Logger LOG = LogManager.getLogger(DataServiceApplication.class);

    private static String DATASET_ENV = "/KKBox-100000";


	public static void main(String[] args) throws Throwable {

		SpringApplication.run(DataServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner init(MemberDao memberDao,
                           SongDao songDao,
                           SongExtraInfoDao songExtraInfoDao,
                           TrainDao trainDao
                           ) {
        return (evt) -> Arrays.asList(
                DATASET_ENV.split(","))
                .forEach(
                        a -> {

							Class mainClass = DataServiceApplication.class.getClass();
							//////////////Member////////////////////////////
							//1.initial CSV reader and mapper.
							URL url_members = mainClass.getResource(DATASET_ENV+"/members.xlsx");
							File excelFile_member = new File(url_members.getPath());
							List<Member> excelFile_members= null;
							try {
								excelFile_members = ExOM.mapFromExcel(excelFile_member)
                                        .toObjectOf(Member.class)
                                        .map();
							} catch (Throwable throwable) {
								throwable.printStackTrace();
							}

							for (Member item : excelFile_members) {
								LOG.debug("Member --> {}"+item.toString());
							}
                            //2.Save to H2 and verify
							memberDao.save(excelFile_members);
							LOG.info(memberDao.findAll().toString());

                            //////////////Song////////////////////////////
                            //1.initial CSV reader and mapper.
                            URL url_songs = mainClass.getResource(DATASET_ENV+"/songs.xlsx");
                            File excelFile_song = new File(url_songs.getPath());
                            List<Song> excelFile_songs = null;
                            try {
                                excelFile_songs = ExOM.mapFromExcel(excelFile_song)
                                        .toObjectOf(Song.class)
                                        .map();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }

                            for (Song item : excelFile_songs) {
                                LOG.debug("Song --> {}"+item.toString());
                            }
                            //2.Save to H2 and verify
                            songDao.save(excelFile_songs);
                            LOG.info(songDao.findAll().toString());

                            //////////////Song////////////////////////////
                            //1.initial CSV reader and mapper.
                            URL url_song_extra_info = mainClass.getResource(DATASET_ENV+"/song_extra_info.xlsx");
                            File excelFile_song_extra_info = new File(url_song_extra_info.getPath());
                            List<SongExtraInfo> excelFile_song_extra_infos = null;
                            try {
                                excelFile_song_extra_infos = ExOM.mapFromExcel(excelFile_song_extra_info)
                                        .toObjectOf(SongExtraInfo.class)
                                        .map();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }

                            for (SongExtraInfo item : excelFile_song_extra_infos) {
                                LOG.debug("SongExtraInfo --> {}"+item.toString());
                            }
                            //2.Save to H2 and verify
                            songExtraInfoDao.save(excelFile_song_extra_infos);
                            LOG.info(songExtraInfoDao.findAll().toString());

                            //////////////Train////////////////////////////
                            //1.initial CSV reader and mapper.
                            URL url_train = mainClass.getResource(DATASET_ENV+"/train.xlsx");
                            File excelFile_train = new File(url_train.getPath());
                            List<Train> excelFile_trains = null;
                            try {
                                excelFile_trains = ExOM.mapFromExcel(excelFile_train)
                                        .toObjectOf(Train.class)
                                        .map();
                            } catch (Throwable throwable) {
                                throwable.printStackTrace();
                            }

                            for (Train item : excelFile_trains) {
                                LOG.debug("Train --> {}"+item.toString());
                            }
                            //2.Save to H2 and verify
                            trainDao.save(excelFile_trains);
                            LOG.info(trainDao.findAll().toString());

                        });
    }
}
