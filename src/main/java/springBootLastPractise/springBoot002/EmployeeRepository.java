package springBootLastPractise.springBoot002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository implements EmployeeImpl{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int saveEmployee(Employee employee) {
        return jdbcTemplate.update("insert into employee (name,email,address,gender,age) values(?,?,?,?,?)",new Object[]{
                employee.getName(),employee.getEmail(),employee.getAddress(),employee.getGender(),employee.getAge()
        });
    }

    @Override
    public List<Employee> getAllEmployee() {
        try {
            return jdbcTemplate.query("select * from employee", new BeanPropertyRowMapper<>(Employee.class));
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Employee getById(int id) {
        try {
            return jdbcTemplate.queryForObject("select * from employee where id=?", new BeanPropertyRowMapper<>(Employee.class), id);
        }catch(Exception e)
        {
            return null;
        }
    }

    @Override
    public String updateEmployee(Employee employee, int id) {
        return jdbcTemplate.update("update employee set name=?,email=?,address=?,gender=?,age=? where id=?",new Object[]{
                employee.getName(),employee.getEmail(),employee.getAddress(),employee.getGender(),employee.getAge(),id
        })+" Successfully updated";
    }

    @Override
    public String deleteById(int id) {
        return jdbcTemplate.update("delete from employee where id=?",id)+" Deleted successfully";
    }

    @Override
    public List<Employee> getByName(String name) {
        try {
            return jdbcTemplate.query("select * from employee where name=?", new BeanPropertyRowMapper<>(Employee.class), name);
        }catch(Exception e)
        {
            return  null;
        }
    }

    @Override
    public int saveDepartment(Department department) {
        return jdbcTemplate.update("insert into department (domain,company) values(?,?)",new Object[]{
                department.getDomain(),department.getCompany()
        });
    }

    @Override
    public List<Department> getAllDepartments() {
        try {
            return jdbcTemplate.query("select * from department", new BeanPropertyRowMapper<>(Department.class));
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public Department getDepartmentById(int dId) {
        try {
            return jdbcTemplate.queryForObject("select * from department where d_id=?", new BeanPropertyRowMapper<>(Department.class), dId);
        }catch (Exception e)
        {
            return null;
        }
    }

    @Override
    public String updateDepartment(Department department, int dId) {
        return jdbcTemplate.update("update department set domain=?,company=? where d_id=?",new Object[]{
                department.getDomain(),department.getCompany(),dId
        })+" department with "+dId+" updated successfully";
    }
}
