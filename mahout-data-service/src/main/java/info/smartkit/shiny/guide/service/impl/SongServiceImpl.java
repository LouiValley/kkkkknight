package info.smartkit.shiny.guide.service.impl;

import info.smartkit.shiny.guide.domain.dto.KKBoxPerfObject;
import info.smartkit.shiny.guide.domain.vo.Song;
import info.smartkit.shiny.guide.service.RecommendService;
import info.smartkit.shiny.guide.service.SongService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    @Autowired
    private RecommendService recommendService;

    @Override
    public  List<RecommendedItem> getSongsWithLikehood(String uid) throws IOException, TasteException {
        List<KKBoxPerfObject> kkBoxPerfObjectArrayList = recommendService.getKkBoxPerfObjectsFromSQL("song_id",uid);
        return recommendService.itemCF(recommendService.getDataModel(kkBoxPerfObjectArrayList));
    }

    @Override
    public List<Song> getSongsWithDiffThemes(String uid) {
        return null;
    }

    @Override
    public List<Song> getSongsWithRecommendation(String uid) {
        return null;
    }

}
