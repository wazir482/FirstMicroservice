package Springboot.FirstMicroservice.EmployeeService;

import Springboot.FirstMicroservice.EmployeeEntity.EmployeeEntity;
import Springboot.FirstMicroservice.EmployeeExceptions.EmployeeNotFoundException;
import Springboot.FirstMicroservice.EmployeeRepository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

@Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {

        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity CreateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    public List<EmployeeEntity> CreateListOfEmployee(List<EmployeeEntity> employeeEntities) {
        return employeeRepository.saveAll(employeeEntities);

    }

    public List<EmployeeEntity> getEmployees() {

        return employeeRepository.findAll();
    }

    public EmployeeEntity GetEmployeeById(Long id) {
        return employeeRepository.findById(id).
                orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id  " + id));
    }

    public EmployeeEntity UpdateEmployeeById(Long id, EmployeeEntity ee)
    {
       EmployeeEntity updateemployee=  employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Not found" +id));
        updateemployee.setName(ee.getName());
        updateemployee.setEmail(ee.getEmail());
        // Update other fields as needed

        // Save the updated user to the database
        return employeeRepository.save(updateemployee);
    }

    public List<EmployeeEntity> updateEmployeeEntity(List<EmployeeEntity> employeeEntities)
    {
        return employeeRepository.saveAll(employeeEntities);
    }
    public String DeleteEmployeeById(Long id)
    {
         employeeRepository.deleteById(id);
         return "Successfully Deleted";
    }
}


