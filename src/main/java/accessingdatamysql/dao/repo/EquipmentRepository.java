package accessingdatamysql.dao.repo;

import com.example.accessingdatamysql.dao.entities.Equipment;
import org.springframework.data.repository.CrudRepository;

public interface EquipmentRepository  extends CrudRepository<Equipment, Integer> {
}
