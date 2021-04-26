package demo.verzn.manager.controller;

import demo.verzn.manager.entity.Department;
import demo.verzn.manager.entity.Employee;
import demo.verzn.manager.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author adarshbhattarai on 2021-04-25
 * @project zuuleureka
 */
@RestController
@CrossOrigin(origins={"http://localhost:3000","http://localhost:3002"})
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/isAvailable")
    public String available() {
        return "Manager is up and running";
    }


    @GetMapping("/departments")
    public List<Department> getDepartments()
    {
        return departmentService.getDepartmentList();
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees()
    {
        return departmentService.getEmployees();
    }


    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee)
    {
         departmentService.saveOrUpdate(employee);
         return employee;
    }

    @PostMapping("/employee")
    public Long createEmployee(@RequestBody Employee employee)
    {
        departmentService.saveOrUpdate(employee);
        return employee.getId();
    }

    @DeleteMapping("/employee/{employeeId}")
    public void createEmployee(@PathVariable("employeeId") Long employeeId)
    {
        departmentService.removeEmployeeById(employeeId);
    }


}
