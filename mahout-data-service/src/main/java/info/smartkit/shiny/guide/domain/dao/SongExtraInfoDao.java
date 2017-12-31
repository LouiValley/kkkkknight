package info.smartkit.shiny.guide.domain.dao;

import info.smartkit.shiny.guide.domain.vo.SongExtraInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongExtraInfoDao extends CrudRepository<SongExtraInfo,Long> {
}
