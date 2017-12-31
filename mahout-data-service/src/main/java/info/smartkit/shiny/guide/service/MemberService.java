package info.smartkit.shiny.guide.service;

import info.smartkit.shiny.guide.domain.dto.SongFullInfo;
import info.smartkit.shiny.guide.domain.vo.Member;
import info.smartkit.shiny.guide.domain.vo.Song;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    List<Song> getSongHistory(String uid);
    List<SongFullInfo> getSongFullInfo(String uid);
    Member getUserInfo(String uid);
    List<Object> getUsersWithLikehood(String uid);
    List<Object> getUsersWithLikehoodAndRecommendation(String uid);
}
