package redSocial.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import redSocial.model.Hobby;

@Repository
public interface HobbyRepository extends Neo4jRepository<Hobby,Long>{

	@Query("match (h) where h.id = $id return h") Hobby findById(@Param("id")Integer id);
	


}
