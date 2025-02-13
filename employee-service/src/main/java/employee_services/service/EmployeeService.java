package employee_services.service;

import employee_services.dao.EmployeeRepository;
import employee_services.entity.Employee;
import employee_services.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    public EmployeeResponse getEmployeeById(int id){
        Employee employee = employeeRepository.findById(id).get();

//        EmployeeResponse employeeResponse = new EmployeeResponse();
//        employeeResponse.setId(employee.getId());
//        employeeResponse.setName(employee.getName());
//        employeeResponse.setEmail(employee.getEmail());
//        employeeResponse.setBloodGroup(employee.getBloodGroup());
        return modelMapper.map(employee, EmployeeResponse.class);
    }
}
