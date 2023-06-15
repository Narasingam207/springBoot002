package springBootLastPractise.springBoot002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;
    public int saveEmployee(Employee employee) {
        return employeeRepository.saveEmployee(employee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    public Employee getById(int id) {

        return employeeRepository.getById(id);
    }

    public String updateEmployee(Employee employee, int id) {

        return employeeRepository.updateEmployee(employee,id);
    }

    public String deleteById(int id) {
        return  employeeRepository.deleteById(id);
    }

    public List<Employee> getByName(String name) {

        return employeeRepository.getByName(name);
    }

    public int saveDepartment(Department department) {
        return employeeRepository.saveDepartment(department);
    }

    public List<Department> getAllDepartments() {
        return employeeRepository.getAllDepartments();
    }

    public Department getDepartmentById(int dId) {
        return employeeRepository.getDepartmentById(dId);
    }

    public String updateDepartment(Department department, int dId) {
        return employeeRepository.updateDepartment(department,dId);
    }
}
