package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.ProductCategory;
import org.springframework.data.repository.CrudRepository;

public interface ProductCategoryRepository  extends CrudRepository<ProductCategory, Integer> {
}
