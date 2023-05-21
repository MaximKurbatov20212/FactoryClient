package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Brigade;
import org.springframework.data.repository.CrudRepository;

public interface BrigadeRepository extends CrudRepository<Brigade, Integer> {
}
