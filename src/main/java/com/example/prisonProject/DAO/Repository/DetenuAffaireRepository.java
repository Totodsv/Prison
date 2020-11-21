package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.DetenuAffaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetenuAffaireRepository extends JpaRepository<DetenuAffaire, String> {
    DetenuAffaire findDetenuAffaireBynEcrouAndNumAffaireAndNomJuridiction(String n_ecrou, String n_affaire, String nom_juridiction);
}
