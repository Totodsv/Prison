package com.example.prisonProject.DAO.Repository;

import com.example.prisonProject.POJO.Decision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface DecisionRepository extends JpaRepository<Decision, String> {
    Decision findDecisionBynEcrouAndNumTypeDecisionAndDateDecision(String n_ecrou, String n_type_decision, Date date_decision);
}
