package info.smartkit.shiny.guide.domain.dao;

import info.smartkit.shiny.guide.domain.vo.Train;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainDao extends CrudRepository<Train,Long> {
}
