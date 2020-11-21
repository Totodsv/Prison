package com.example.prisonProject.DAO.Repository;


import com.example.prisonProject.POJO.ReductionPeine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReductionPeineRepository extends JpaRepository<ReductionPeine, String> {

    ReductionPeine findReductionPeineBynEcrouAndNumTypeDecisionAndDateDecision(String n_ecrou, String n_type_decision,  Date date_decision);

}
