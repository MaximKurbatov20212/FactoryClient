package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.PersonalFunction;
import org.springframework.data.repository.CrudRepository;

public interface PersonalFunctionRepository extends CrudRepository<PersonalFunction, Integer> {}
