package com.nedioit.employe.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class EmployeResponse {

    private Long id;
    private String nom;
    private String prenom;
    private String poste;
    private double salaire;

    public EmployeResponse(Long id, String nom, String prenom, String poste, double salaire) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.salaire = salaire;
    }
}
