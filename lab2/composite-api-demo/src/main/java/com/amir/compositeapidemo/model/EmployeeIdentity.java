package com.amir.compositeapidemo.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeIdentity implements Serializable{

    @NotNull
    @Size(max = 20)
    private String employeeId;
    @NotNull
    @Size(max = 20)
    private String companyId;
}
