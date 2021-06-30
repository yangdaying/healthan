package com.health.app.service;

import com.health.app.bean.Employee;
import com.health.app.dao.EmployeeRepository;
import com.health.app.exception.MyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    //@Autowired
    private EmployeeRepository employeeRepository;

    EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findOneByid(Long id) {
        return employeeRepository.findById(id).orElseThrow(()->new MyException("user of "+id+" not found"));
        //return employeeRepository.findById(id);
    }

    public void deleteByid(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            logger.info("user is present ,now begin delete it");
            employeeRepository.deleteById(id);
            logger.info("user is present ,now  delete finished");
        }else {
            throw new MyException("user of "+id+" not found");
        }

    }
}