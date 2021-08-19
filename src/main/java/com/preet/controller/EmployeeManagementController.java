package com.preet.controller;

import com.preet.domain.Employee;
import com.preet.service.EmployeeManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeManagementController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeManagementController.class);

    @Autowired
    private EmployeeManagementService employeeManagementService;

    @PostMapping(value = "/insert")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        logger.info("addEmployee - employee {}", employee);
        try {
            employeeManagementService.addEmployee(employee);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        logger.info("updateEmployee - employee {}", employee);
        try {
            if (employeeManagementService.updateEmployee(employee)) {
                return ResponseEntity.accepted().build();
            } else {
                return ResponseEntity.noContent().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable String id) {
        logger.info("deleteEmployee - id {}", id);
        try {
            employeeManagementService.deleteEmployee(id);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
