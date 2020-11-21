package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.LiberationDefinitive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface LiberationDefinitiveRepository extends JpaRepository<LiberationDefinitive, String> {

    LiberationDefinitive findLiberationDefinitiveBynEcrouAndNumTypeDecisionAndDateDecision(String n_ecrou, String n_type_decision,  Date date_decision);
}
