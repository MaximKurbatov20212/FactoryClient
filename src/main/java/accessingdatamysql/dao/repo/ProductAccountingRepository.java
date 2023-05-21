package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductAccounting;
import org.springframework.data.repository.CrudRepository;

public interface ProductAccountingRepository  extends CrudRepository<ProductAccounting, Integer> {
}
