package com.nedioit.employe.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeRequest {

    private String nom;
    private String prenom;
    private String poste;
    private double salaire;
}
