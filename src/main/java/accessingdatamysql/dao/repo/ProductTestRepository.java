package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductTest;
import org.springframework.data.repository.CrudRepository;

public interface ProductTestRepository  extends CrudRepository<ProductTest, Integer> {
}
