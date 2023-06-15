package springBootLastPractise.springBoot002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @PostMapping()
    public ResponseEntity<Integer> saveEmployee(@RequestBody Employee employee)
    {
        int employee1 = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(employee1, HttpStatus.OK);
    }
  @GetMapping()
    public ResponseEntity<Object> getAllEmployee()
    {
        List<Employee> employee2 = employeeService.getAllEmployee();
        if(employee2.size()==0)
        {
            ErrorMessage errorMessage=new ErrorMessage("There are no Employees in the employee table");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee2,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") int id)
    {
        Employee employee3 = employeeService.getById(id);
        if(employee3==null)
        {
            ErrorMessage errorMessage=new ErrorMessage("Employee with id "+id+" doesn't exist");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        return  new ResponseEntity<>(employee3,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Object> updateEmployee(@RequestBody Employee employee,@PathVariable("id") int id)
    {
        Employee employee4 = employeeService.getById(id);
        if(employee4==null)
        {
            ErrorMessage errorMessage=new ErrorMessage("Employee cannot be updated because Employee with id "+id+" doesn't exist");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        String employee3 = employeeService.updateEmployee(employee, id);
        return new ResponseEntity<>(employee3,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id)
    {
        Employee employee1 = employeeService.getById(id);
        if(employee1==null)
        {
            ErrorMessage errorMessage=new ErrorMessage("Employee cannot be deleted because Employee with id "+id+" doesn't exist");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        String employee5 = employeeService.deleteById(id);
        return new ResponseEntity<>(employee5,HttpStatus.OK);
    }
@GetMapping("/name/{name}")
public ResponseEntity<Object> getByName(@PathVariable("name") String name)
{
    List<Employee> employee1 = employeeService.getByName(name);

    if(employee1.size()==0)
    {
        ErrorMessage errorMessage=new ErrorMessage("Employee with the name "+name+" doesn't exist ");
        return  new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }
    return  new ResponseEntity<>(employee1,HttpStatus.OK);
}
@PostMapping("/department")
    public ResponseEntity<Integer> saveDepartment(@RequestBody Department department) {

        int department1 = employeeService.saveDepartment(department);
        return new ResponseEntity<>(department1,HttpStatus.OK);
    }
    @GetMapping("/department")
    public ResponseEntity<Object> getAllDepartments()
    {
        List<Department> employee1 = employeeService.getAllDepartments();

        if(employee1.size()==0)
        {
            ErrorMessage errorMessage=new ErrorMessage("There are no departments currently");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }
    @GetMapping("/department/{dId}")
    public ResponseEntity<Object> getDepartmentById(@PathVariable("dId") int dId)
    {
        Department employee1 = employeeService.getDepartmentById(dId);

        if(employee1==null)
        {
            ErrorMessage errorMessage=new ErrorMessage("department with id "+dId+" doesn't exist");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee1,HttpStatus.OK);
    }
    @PutMapping("/department/{dId}")
    public ResponseEntity<Object> updateDepartment(@RequestBody Department department,@PathVariable ("dId") int dId)
    {
        Department department1=employeeService.getDepartmentById(dId);
        if(department1==null)
        {
            ErrorMessage errorMessage=new ErrorMessage("department with id "+dId+" doesn't exist please check with new id");
            return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
        }
        String department2 = employeeService.updateDepartment(department, dId);
        return new ResponseEntity<>(department2,HttpStatus.OK);
    }


















}
