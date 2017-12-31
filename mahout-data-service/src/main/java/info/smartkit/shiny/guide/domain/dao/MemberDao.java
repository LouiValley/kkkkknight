package info.smartkit.shiny.guide.domain.dao;

import info.smartkit.shiny.guide.domain.vo.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends CrudRepository<Member,Long> {
}
