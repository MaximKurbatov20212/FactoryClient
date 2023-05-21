package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository  extends CrudRepository<Product, Integer> {
}
