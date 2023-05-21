package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.PersonalCategory;
import org.springframework.data.repository.CrudRepository;

public interface PersonalCategoryRepository extends CrudRepository<PersonalCategory, Integer> {}
