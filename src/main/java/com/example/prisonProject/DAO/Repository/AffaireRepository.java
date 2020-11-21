package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.Affaire;
import com.example.prisonProject.POJO.AffairePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.SqlResultSetMapping;
import java.util.Collection;

@Repository
public interface AffaireRepository extends JpaRepository<Affaire, String> {

    Affaire findAffaireByNumAffaireAndNomJuridiction(String n_affaire, String nom_juridiction);

}
