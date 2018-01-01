package info.smartkit.shiny.guide.service.impl;

import com.mahout.rnd.customFileModel.PaxcomFileDataModel;
import com.mahout.rnd.customFileModel.retrieveDataFromIndex;
import info.smartkit.shiny.guide.DataServiceApplication;
import info.smartkit.shiny.guide.domain.dao.MemberDao;
import info.smartkit.shiny.guide.domain.dao.SongDao;
import info.smartkit.shiny.guide.domain.dao.SongExtraInfoDao;
import info.smartkit.shiny.guide.domain.dao.TrainDao;
import info.smartkit.shiny.guide.domain.dto.KKBoxPerfObject;
import info.smartkit.shiny.guide.domain.dto.SongFullInfo;
import info.smartkit.shiny.guide.domain.vo.Member;
import info.smartkit.shiny.guide.domain.vo.Song;
import info.smartkit.shiny.guide.service.MemberService;
import info.smartkit.shiny.guide.service.RecommendService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.common.LongPrimitiveIterator;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.EuclideanDistanceSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.TanimotoCoefficientSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.ItemSimilarity;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {


    private static Logger LOG = LogManager.getLogger(MemberServiceImpl.class);

    @Autowired
    MemberDao memberDao;

    @Autowired
    SongDao songDao;

    @Autowired
    SongExtraInfoDao songExtraInfoDao;

    @Autowired
    TrainDao trainDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RecommendService recommendService;

    @Override
    public List<Song> getSongHistory(String uid) {
        String SQL_member_song_info = "select song.*,train.* FROM song left join train on train.song_id = song.song_id WHERE train.msno='"+uid+"'";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL_member_song_info);
        List<Song> songList = new ArrayList<Song>();
        //
        while (rows.next()) {
            //
            int colCount = rows.getMetaData().getColumnCount();
            Song song = new Song();
            for (int i = 1; i <= colCount; i++) {
                song.setSong_id(rows.getString("song_id"));
                song.setSong_length(rows.getString("song_length"));
                song.setGenre_ids(rows.getString("genre_ids"));
                song.setArtist_name(rows.getString("artist_name"));
                song.setComposer(rows.getString("composer"));
                song.setLyricist(rows.getString("lyricist"));
                song.setLanguage(rows.getString("language"));
            }
            songList.add(song);
        }
        return songList;
    }

    @Override
    public List<SongFullInfo> getSongFullInfo(String uid) {

        String SQL_member_song_full_info = "select song.*,song_extra_info.* FROM song left join song_extra_info on song.song_id = song_extra_info.song_id WHERE song.song_id='"+uid+"'";
        SqlRowSet rows = jdbcTemplate.queryForRowSet(SQL_member_song_full_info);
        List<SongFullInfo> songList = new ArrayList<SongFullInfo>();
        //
        while (rows.next()) {
            //
            int colCount = rows.getMetaData().getColumnCount();
            SongFullInfo song = new SongFullInfo();
            for (int i = 1; i <= colCount; i++) {
                song.setSong_id(rows.getString("song_id"));
                song.setSong_length(rows.getString("song_length"));
                song.setGenre_ids(rows.getString("genre_ids"));
                song.setArtist_name(rows.getString("artist_name"));
                song.setComposer(rows.getString("composer"));
                song.setLyricist(rows.getString("lyricist"));
                song.setLanguage(rows.getString("language"));
                song.setName(rows.getString("name"));
                song.setIsrc(rows.getString("isrc"));
            }
            songList.add(song);
        }
        return songList;
    }

    @Override
    public Member getUserInfo(String uid) {
        return memberDao.findByMsno(uid);
    }

    @Override
    public List<RecommendedItem> getUsersWithLikehood(String uid) throws IOException, TasteException {
        List<KKBoxPerfObject> kkBoxPerfObjectArrayList = recommendService.getKkBoxPerfObjectsFromSQL("msno",uid);

        File file = new File(KKBoxUtils.CSV_BEAN_FILE);
        DataModel dataModel  = new PaxcomFileDataModel(file);

        UserSimilarity similarity = new PearsonCorrelationSimilarity(dataModel);
        UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, dataModel);
        UserBasedRecommender recommender = new GenericUserBasedRecommender(dataModel, neighborhood, similarity);

        List<RecommendedItem> recommendations = recommender.recommend(Long.parseLong(uid), 3);
        for (RecommendedItem recommendation : recommendations) {
            LOG.info(recommendation);
        }

        return recommendations;
//        return recommendService.userCF(recommendService.getDataModel(kkBoxPerfObjectArrayList));

    }


    @Override
    public List<RecommendedItem> getUsersWithLikehoodAndRecommendation(String uid) throws IOException, TasteException {

        List<KKBoxPerfObject> kkBoxPerfObjectArrayList = recommendService.getKkBoxPerfObjectsFromSQL("msno",uid);
        //
        return recommendService.userCF(recommendService.getDataModel(kkBoxPerfObjectArrayList));
    }


}
