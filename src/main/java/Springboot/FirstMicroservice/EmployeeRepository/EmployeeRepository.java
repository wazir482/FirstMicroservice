package Springboot.FirstMicroservice.EmployeeRepository;

import Springboot.FirstMicroservice.EmployeeEntity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>
{

}
