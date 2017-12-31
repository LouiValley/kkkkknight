package info.smartkit.shiny.guide.domain.dao;

import info.smartkit.shiny.guide.domain.vo.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongDao extends CrudRepository<Song,Long> {
}
