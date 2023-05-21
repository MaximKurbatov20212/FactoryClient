package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Laboratory;
import org.springframework.data.repository.CrudRepository;

public interface LaboratoryRepository  extends CrudRepository<Laboratory, Integer> {
}
