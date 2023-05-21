package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.WorkerAttributeValue;
import org.springframework.data.repository.CrudRepository;

public interface WorkerAttributeValueRepository extends CrudRepository<WorkerAttributeValue, Integer> {
}
