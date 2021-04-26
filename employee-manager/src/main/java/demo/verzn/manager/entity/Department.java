package demo.verzn.manager.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * @author adarshbhattarai on 2021-04-26
 * @project zuuleureka
 */
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String dept_name;

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }


}
