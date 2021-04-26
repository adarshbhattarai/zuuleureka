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
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/isAvailable")
    public String available() {
        return "Manager is up and running";
    }


    @GetMapping("/departments")
    private List<Department> getDepartments()
    {
        return departmentService.getDepartmentList();
    }


}
