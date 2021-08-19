package com.preet.service.impl;

import com.preet.dto.EmployeeTO;
import com.preet.entity.EmployeeEntity;
import com.preet.repository.EmployeeDAO;
import com.preet.service.InfoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InfoEmployeeServiceImpl implements InfoEmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public List<EmployeeTO> getAllEmployee() throws Exception {
        return employeeDAO.findAll().stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeTO getEmployeeById(String id) throws Exception {
        EmployeeTO employeeTO = null;
        Optional<EmployeeEntity> employeeEntityOptional = employeeDAO.findById(Long.parseLong(id));
        if (employeeEntityOptional.isPresent()) {
            EmployeeEntity employeeEntity = employeeEntityOptional.get();
            employeeTO = transform(employeeEntity);
        }
        return employeeTO;
    }

    private EmployeeTO transform(EmployeeEntity employeeEntity) {
        EmployeeTO employeeTO = new EmployeeTO();
        employeeTO.setId(employeeEntity.getId());
        employeeTO.setName(employeeEntity.getName());
        employeeTO.setSurname(employeeEntity.getSurname());
        return employeeTO;
    }

}
