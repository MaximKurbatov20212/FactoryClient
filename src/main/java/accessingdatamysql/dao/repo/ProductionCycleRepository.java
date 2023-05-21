package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductionCycle;
import org.springframework.data.repository.CrudRepository;

public interface ProductionCycleRepository  extends CrudRepository<ProductionCycle, Integer> {
}
