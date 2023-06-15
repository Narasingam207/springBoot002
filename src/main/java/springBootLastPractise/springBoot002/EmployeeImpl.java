package springBootLastPractise.springBoot002;

import java.util.List;

public interface EmployeeImpl {
    int saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getById(int id);

    String updateEmployee(Employee employee, int id);

    String deleteById(int id);

    List<Employee> getByName(String name);

    int saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(int dId);

    String updateDepartment(Department department, int dId);
}
