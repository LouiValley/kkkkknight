package info.smartkit.shiny.guide.service.impl;

import info.smartkit.shiny.guide.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public List<Object> getHistory(String uid) {
        return null;
    }

    @Override
    public Object getSongInfo(String uid) {
        return null;
    }

    @Override
    public Object getUserInfo(String uid) {
        return null;
    }

    @Override
    public List<Object> getUsersWithLikehood(String uid) {
        return null;
    }

    @Override
    public List<Object> getUsersWithLikehoodAndRecommendation(String uid) {
        return null;
    }
}