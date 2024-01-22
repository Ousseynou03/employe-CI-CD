package com.nedioit.employe.service;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nedioit.employe.dto.EmployeRequest;
import com.nedioit.employe.dto.EmployeResponse;
import com.nedioit.employe.entities.Employe;
import com.nedioit.employe.mapper.EmployeMapper;
import com.nedioit.employe.repository.EmployeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeServiceImpl implements IEmployeService {

    private final EmployeRepository employeRepository;
    private final EmployeMapper employeMapper;

    public EmployeServiceImpl(EmployeRepository employeRepository, EmployeMapper employeMapper) {
        this.employeRepository = employeRepository;
        this.employeMapper = employeMapper;
    }

    @Override
    public EmployeResponse add(EmployeRequest employeRequest) {
        try {
            Employe employe = employeMapper.fromEmployeRequest(employeRequest);
            employeRepository.save(employe);
            return employeMapper.fromEmploye(employe);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public EmployeResponse getEmployeById(Long id) {
        Optional<Employe> optionalEmploye = employeRepository.findById(id);
        if(optionalEmploye.isPresent()){
            return employeMapper.fromEmploye(optionalEmploye.get());
        }else {
            throw new EntityNotFoundException("Prodcut with id " +id+ " not found");
        }
    }

    @Override
    public List<EmployeResponse> getAllEmployes() {
        Sort sortById = Sort.by(Sort.Direction.DESC, "id");
        List<Employe> employes = employeRepository.findAll(sortById);
        List<EmployeResponse> employeRespons = new ArrayList<>();
        for (Employe p : employes){
            employeRespons.add(employeMapper.fromEmploye(p));
        }

        return employeRespons;
    }

    @Override
    public EmployeResponse updateEmploye(Long id, EmployeRequest employeRequest) {
        Optional<Employe> optionalProduct = employeRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Employe employe = optionalProduct.get();
            employe.setNom(employeRequest.getNom());
            employe.setPrenom(employeRequest.getPrenom());
            employe.setPoste(employeRequest.getPoste());
            employe.setSalaire(employeRequest.getSalaire());

            employeRepository.save(employe);

            return employeMapper.fromEmploye(employe);
        } else {
            throw new EntityNotFoundException("Employe with id " + id + " not found");
        }
    }

    @Override
    public void deleteEmploye(Long id) {
        Optional<Employe> optionalProduct = employeRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Employe employe = optionalProduct.get();
            employeRepository.delete(employe);
        } else {
            throw new EntityNotFoundException("Employe with id " + id + " not found");
        }
    }


}
