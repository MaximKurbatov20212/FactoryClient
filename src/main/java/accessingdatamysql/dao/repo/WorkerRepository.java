package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository  extends CrudRepository<Worker, Integer> {
}
