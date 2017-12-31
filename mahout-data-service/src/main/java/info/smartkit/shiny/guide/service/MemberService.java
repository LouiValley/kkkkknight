package info.smartkit.shiny.guide.service;

import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberService {
    List<Object> getHistory(String uid);
    Object getSongInfo(String uid);
    Object getUserInfo(String uid);
    List<Object> getUsersWithLikehood(String uid);
    List<Object> getUsersWithLikehoodAndRecommendation(String uid);
}
