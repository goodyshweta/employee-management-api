package com.preet.controller;

import com.preet.dto.EmployeeTO;
import com.preet.service.InfoEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/employee-info")
public class InfoEmployeeController {

    @Autowired
    private InfoEmployeeService infoEmployeeService;

    @GetMapping
    ResponseEntity<?> getEmployeeInfo() {
        List<EmployeeTO> employeeList = null;
        try {
            employeeList = infoEmployeeService.getAllEmployee();
            if (CollectionUtils.isEmpty(employeeList)) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(employeeList);
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> getEmployeeInfoById(@PathVariable String id) {
        EmployeeTO employee = null;
        try {
            employee = infoEmployeeService.getEmployeeById(id);
            if (employee != null) {
                return ResponseEntity.ok(employee);
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
