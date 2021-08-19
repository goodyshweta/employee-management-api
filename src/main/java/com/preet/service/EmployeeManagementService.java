package com.preet.service;

import com.preet.domain.Employee;

public interface EmployeeManagementService {

    /**
     * @param employee
     */
    void addEmployee(Employee employee) throws Exception;

    /**
     * @param employee
     * @return
     */
    boolean updateEmployee(Employee employee) throws Exception;

    /**
     * @param id
     */
    void deleteEmployee(String id) throws Exception;
}
