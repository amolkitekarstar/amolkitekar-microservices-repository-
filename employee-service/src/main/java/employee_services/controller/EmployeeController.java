package employee_services.controller;

import employee_services.dao.EmployeeRepository;
import employee_services.entity.Employee;
import employee_services.response.EmployeeResponse;
import employee_services.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        ResponseEntity response = ResponseEntity.status(HttpStatus.OK).body(employee);
        return response;
    }
}
