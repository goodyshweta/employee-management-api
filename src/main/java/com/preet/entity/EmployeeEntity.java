package com.preet.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@ToString
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

    @Id
    private int id;
    private String name;
    private String surname;
}
