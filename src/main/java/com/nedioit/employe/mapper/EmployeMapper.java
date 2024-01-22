package com.nedioit.employe.mapper;



import com.nedioit.employe.dto.EmployeRequest;
import com.nedioit.employe.dto.EmployeResponse;
import com.nedioit.employe.entities.Employe;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeMapper {

    public EmployeResponse fromEmploye(Employe employe){
        EmployeResponse employeResponse = new EmployeResponse();
        BeanUtils.copyProperties(employe, employeResponse);
        return employeResponse;
    }

    public Employe fromEmployeRequest(EmployeRequest employeRequest){
        Employe employe = new Employe();
        BeanUtils.copyProperties(employeRequest, employe);
        return employe;
    }
}
