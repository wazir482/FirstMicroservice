package Springboot.FirstMicroservice.EmployeeExceptions;

import org.aspectj.bridge.IMessage;

public class EmployeeNotFoundException extends RuntimeException{
public EmployeeNotFoundException(String Message)
{

    super(Message);
}
}
