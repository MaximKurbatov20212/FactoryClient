package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.PersonalCategoryAttribute;
import org.springframework.data.repository.CrudRepository;

public interface PersonalCategoryAttributeRepository extends CrudRepository<PersonalCategoryAttribute, Integer> {}
