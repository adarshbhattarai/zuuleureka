package demo.verzn.manager.repository;

import demo.verzn.manager.entity.Department;
import org.springframework.data.repository.CrudRepository;

/**
 * @author adarshbhattarai on 2021-04-26
 * @project zuuleureka
 */
public interface DepartmentRepository extends CrudRepository<Department,Long> {
}
