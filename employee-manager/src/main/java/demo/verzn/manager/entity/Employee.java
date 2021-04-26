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
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private Long deptId;

    public Employee(String first_name, String last_name, String email, Long deptId) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.deptId = deptId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
