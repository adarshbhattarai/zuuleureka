package demo.verzn.manager.repository;

import demo.verzn.manager.entity.Department;
import demo.verzn.manager.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author adarshbhattarai on 2021-04-26
 * @project zuuleureka
 */
public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
