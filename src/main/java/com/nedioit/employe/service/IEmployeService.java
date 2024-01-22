package com.nedioit.employe.service;



import com.nedioit.employe.dto.EmployeRequest;
import com.nedioit.employe.dto.EmployeResponse;

import java.util.List;

public interface IEmployeService {

    EmployeResponse add(EmployeRequest employeRequest);

    public EmployeResponse getEmployeById(Long id);

    List<EmployeResponse> getAllEmployes();

    //update
    EmployeResponse updateEmploye(Long id, EmployeRequest employeRequest);

    //delete
    void deleteEmploye(Long id);







}
