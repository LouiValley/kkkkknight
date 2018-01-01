package info.smartkit.shiny.guide.service;

import info.smartkit.shiny.guide.domain.dto.SongFullInfo;
import info.smartkit.shiny.guide.domain.vo.Member;
import info.smartkit.shiny.guide.domain.vo.Song;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface MemberService {
    List<Song> getSongHistory(String uid);
    List<SongFullInfo> getSongFullInfo(String uid);
    Member getUserInfo(String uid);
    List<RecommendedItem> getUsersWithLikehood(String uid) throws IOException, TasteException;
    List<RecommendedItem> getUsersWithLikehoodAndRecommendation(String uid) throws IOException, TasteException;
}
