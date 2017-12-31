package info.smartkit.shiny.guide.service;

import info.smartkit.shiny.guide.domain.vo.Song;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SongService {
    List<Song> getSongsWithLikehood(String uid);
    List<Song> getSongsWithDiffThemes(String uid);
    List<Song> getSongsWithRecommendation(String uid);
}
