package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.WorkerCategoryAttribute;
import org.springframework.data.repository.CrudRepository;

public interface WorkerCategoryAttributeRepository  extends CrudRepository<WorkerCategoryAttribute, Integer> {
}
