package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductType;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository  extends CrudRepository<ProductType, Integer> {
}
