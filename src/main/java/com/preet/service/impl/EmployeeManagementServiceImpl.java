package com.preet.service.impl;

import com.preet.domain.Employee;
import com.preet.entity.EmployeeEntity;
import com.preet.repository.EmployeeDAO;
import com.preet.service.EmployeeManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeManagementServiceImpl.class);

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public void addEmployee(Employee employee) throws Exception {
        logger.info("addEmployee - employee {}", employee);
        employeeDAO.save(transformer(employee));
    }

    @Override
    public boolean updateEmployee(Employee employee) throws Exception {
        logger.info("updateEmployee - employee {}", employee);
        boolean update = false;
        Optional<EmployeeEntity> employeeEntityOptional = employeeDAO.findById(employee.getId());
        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            employeeEntity.setName(employee.getName());
            employeeEntity.setSurname(employee.getSurname());
            employeeDAO.save(employeeEntity);
            update = true;
        }
        return update;
    }

    @Override
    public void deleteEmployee(String id) throws Exception {
        logger.info("deleteEmployee - id {}", id);
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(Integer.parseInt(id));
        employeeDAO.delete(employeeEntity);
    }

    private EmployeeEntity transformer(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employee.getId());
        employeeEntity.setName(employee.getName());
        employeeEntity.setSurname(employee.getSurname());
        return employeeEntity;
    }

}
