package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Workshop;
import org.springframework.data.repository.CrudRepository;

public interface WorkshopRepository extends CrudRepository<Workshop, Integer> { }
