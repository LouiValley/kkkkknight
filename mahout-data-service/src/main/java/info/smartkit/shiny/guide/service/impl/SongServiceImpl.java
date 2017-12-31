package info.smartkit.shiny.guide.service.impl;

import info.smartkit.shiny.guide.domain.vo.Song;
import info.smartkit.shiny.guide.service.SongService;

import java.util.List;

public class SongServiceImpl implements SongService{
    @Override
    public List<Song> getSongsWithLikehood(String uid) {
        return null;
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
