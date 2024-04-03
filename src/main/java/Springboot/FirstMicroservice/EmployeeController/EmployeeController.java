package Springboot.FirstMicroservice.EmployeeController;

import Springboot.FirstMicroservice.EmployeeEntity.EmployeeEntity;
import Springboot.FirstMicroservice.EmployeeService.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD OPERATION RELATED TO PROJECT",
        description = "CREATE, VIEW, VIEW BY ID, UPDATE BY ID & DELETE BY ID"
)
@RestController
@RequestMapping("api")
public class EmployeeController {
    @Autowired
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    
    @PostMapping("/add1")
public ResponseEntity<EmployeeEntity> addEmployee(@RequestBody EmployeeEntity employeeEntity)
{
    EmployeeEntity e1= employeeService.CreateEmployee(employeeEntity);
    return ResponseEntity.status(HttpStatus.CREATED).body(e1);
}

@PostMapping("/add2")
public ResponseEntity<List<EmployeeEntity>> addEmployee1(@RequestBody List<EmployeeEntity> employeeEntities)
{
    List<EmployeeEntity> e2= employeeService.CreateListOfEmployee(employeeEntities);
    return ResponseEntity.status(HttpStatus.CREATED).body(e2);
}

@GetMapping("/get1")
public ResponseEntity<List<EmployeeEntity>> getAllEmployees()
{
    List<EmployeeEntity> e3= employeeService.getEmployees();
    return ResponseEntity.ok(e3);
}

@GetMapping("/get2/{id}")
public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable Long id)
{
    EmployeeEntity e4= employeeService.GetEmployeeById(id);
    return ResponseEntity.ok(e4);
}

@PutMapping("/update/{id}")
public ResponseEntity<EmployeeEntity> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeEntity es )
{
    EmployeeEntity e5= employeeService.UpdateEmployeeById(id,es);
    return ResponseEntity.ok(e5);
}

@PutMapping("/updates")
public ResponseEntity<List<EmployeeEntity>> updateEmployee(@RequestBody List<EmployeeEntity> employeeEntities)
{
    List<EmployeeEntity> e6=employeeService.updateEmployeeEntity(employeeEntities);
    return  ResponseEntity.ok(e6);
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id)
{
    employeeService.DeleteEmployeeById(id);
    return ResponseEntity.status(HttpStatus.OK).body("Employee has been deleted with Id  "+id);
}
}
