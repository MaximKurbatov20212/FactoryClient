package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.EventWithProduct;
import org.springframework.data.repository.CrudRepository;

public interface EventWithProductRepository  extends CrudRepository<EventWithProduct, Integer> {
}
