package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.Condamnation;
import com.example.prisonProject.POJO.Incarceration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CondamnationRepository extends JpaRepository<Condamnation,String> {
    Condamnation findCondamnationBynEcrouAndNumTypeDecisionAndDateDecision(String n_ecrou, String n_type_decision, Date date_decision);
    @Override
    List<Condamnation> findAll();
}
