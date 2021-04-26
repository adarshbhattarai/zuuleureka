package demo.verzn.manager.service;

import demo.verzn.manager.entity.Department;
import demo.verzn.manager.entity.Employee;
import demo.verzn.manager.repository.DepartmentRepository;
import demo.verzn.manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author adarshbhattarai on 2021-04-26
 * @project zuuleureka
 */

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Department> getDepartmentList(){
        List<Department> ret = new ArrayList<>();
        departmentRepository.findAll().forEach(department -> ret.add(department));
        return ret;
    }

    public List<Employee> getEmployees(){
        List<Employee> ret = new ArrayList<>();
        employeeRepository.findAll().forEach(emp -> ret.add(emp));
        return ret;
    }

    public Employee getEmployeeByID(Long id){
        return employeeRepository.findById(id).get();
    }

    public void saveOrUpdate(Employee employee)
    {
        employeeRepository.save(employee);
    }

    public void update(Employee employee, int employeeId)
    {
        employeeRepository.save(employee);
    }

    public void removeEmployeeById( Long employeeId)
    {
        employeeRepository.deleteById(employeeId);
    }
}
