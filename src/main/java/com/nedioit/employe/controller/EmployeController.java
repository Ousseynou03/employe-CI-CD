package com.nedioit.employe.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nedioit.employe.dto.EmployeRequest;
import com.nedioit.employe.dto.EmployeResponse;
import com.nedioit.employe.service.IEmployeService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employe")
public class EmployeController {


    private final IEmployeService iEmployeService;

    public EmployeController(IEmployeService iEmployeService) {
        this.iEmployeService = iEmployeService;
    }

    @PostMapping("/add")
    public EmployeResponse addProduct(@RequestBody EmployeRequest employeRequest){
        return iEmployeService.add(employeRequest);
    }

    @GetMapping("/{id}")
    public EmployeResponse getEmployeById(@PathVariable("id") Long id){
        return iEmployeService.getEmployeById(id);
    }

    @GetMapping("/")
    public List<EmployeResponse> getAllEmployes() {
        return iEmployeService.getAllEmployes();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeResponse> updateEmploye(
            @PathVariable Long id,
            @RequestBody EmployeRequest employeRequest) {
        EmployeResponse updatedEmploye = iEmployeService.updateEmploye(id, employeRequest);
        return new ResponseEntity<>(updatedEmploye, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmploye(@PathVariable Long id) {
        iEmployeService.deleteEmploye(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
