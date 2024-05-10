package com.amir.compositeapidemo.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    @EmbeddedId
    private EmployeeIdentity employeeIdentity;
    @NotNull
    @Size(max = 60)
    private String name;
    @NaturalId
    @NotNull
    @Email
    @Size(max = 60)
    private String email;
    @Size(max = 15)
    @Column(name = "phone_number" , unique= true)
    private String phoneNumber;



    
}
