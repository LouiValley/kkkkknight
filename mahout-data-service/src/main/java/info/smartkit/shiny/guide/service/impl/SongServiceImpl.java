package info.smartkit.shiny.guide.service.impl;

import com.mahout.rnd.customFileModel.PaxcomFileDataModel;
import info.smartkit.shiny.guide.domain.dto.KKBoxPerfObject;
import info.smartkit.shiny.guide.domain.vo.Song;
import info.smartkit.shiny.guide.service.RecommendService;
import info.smartkit.shiny.guide.service.SongService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.CachingRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericItemBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.GenericItemSimilarity;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
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
import java.util.Collection;
import java.util.List;

@Service
public class SongServiceImpl implements SongService{

    private static Logger LOG = LogManager.getLogger(SongServiceImpl.class);

    @Autowired
    private RecommendService recommendService;

    @Override
    public  List<RecommendedItem> getSongsWithLikehood(String uid) throws IOException, TasteException {
//        List<KKBoxPerfObject> kkBoxPerfObjectArrayList = recommendService.getKkBoxPerfObjectsFromSQL("song_id",uid);
//        return recommendService.itemCF(recommendService.getDataModel(kkBoxPerfObjectArrayList));

        List<KKBoxPerfObject> kkBoxPerfObjectArrayList = recommendService.getKkBoxPerfObjectsFromSQL("msno",uid);

        File file = new File(KKBoxUtils.CSV_BEAN_FILE);
        DataModel dataModel  = new PaxcomFileDataModel(file);

        // Construct the list of pre-computed correlations
        Collection<GenericItemSimilarity.ItemItemSimilarity> correlations =
                new ArrayList<GenericItemSimilarity.ItemItemSimilarity>();

        ItemSimilarity itemSimilarity =
                new GenericItemSimilarity(correlations);

        Recommender recommender =
                new GenericItemBasedRecommender(dataModel, itemSimilarity);
        Recommender cachingRecommender = new CachingRecommender(recommender);
        List<RecommendedItem> recommendations =
                cachingRecommender.recommend(Long.parseLong(uid), 10);
        for (RecommendedItem recommendation : recommendations) {
            LOG.info(recommendation);
        }
        return recommendations;
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
