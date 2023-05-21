package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.WorkerAccounting;
import org.springframework.data.repository.CrudRepository;

public interface WorkerAccountingRepository  extends CrudRepository<WorkerAccounting, Integer> {
}
