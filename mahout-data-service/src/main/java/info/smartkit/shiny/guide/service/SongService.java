package info.smartkit.shiny.guide.service;

import info.smartkit.shiny.guide.domain.vo.Song;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface SongService {
    List<RecommendedItem> getSongsWithLikehood(String uid) throws IOException, TasteException;
    List<Song> getSongsWithDiffThemes(String uid);
    List<Song> getSongsWithRecommendation(String uid);
}
