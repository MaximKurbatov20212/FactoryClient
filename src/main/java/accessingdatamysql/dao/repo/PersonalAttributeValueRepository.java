package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.PersonalAttributeValue;
import org.springframework.data.repository.CrudRepository;

public interface PersonalAttributeValueRepository  extends CrudRepository<PersonalAttributeValue, Integer> {
}
